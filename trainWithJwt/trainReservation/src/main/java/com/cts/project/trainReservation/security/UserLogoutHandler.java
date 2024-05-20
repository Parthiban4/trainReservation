package com.cts.project.trainReservation.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.cts.project.trainReservation.model.Token;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class UserLogoutHandler implements LogoutHandler {

	    private final TokenRepository tokenRepository;

	    public UserLogoutHandler(TokenRepository tokenRepository) {
	        this.tokenRepository = tokenRepository;
	    }

		@Override
		public void logout(HttpServletRequest request, HttpServletResponse response,
				org.springframework.security.core.Authentication authentication) {
			// TODO Auto-generated method stub
			String authHeader = request.getHeader("Authorization");

	        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
	            return;
	        }

	        String token = authHeader.substring(7);
	        Token storedToken = tokenRepository.findByToken(token).orElse(null);

	        if(storedToken != null) {
	            storedToken.setLoggedOut(true);
	            tokenRepository.save(storedToken);
	        }
		}

}
