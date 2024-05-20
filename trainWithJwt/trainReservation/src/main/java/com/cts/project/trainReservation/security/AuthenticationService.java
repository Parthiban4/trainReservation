package com.cts.project.trainReservation.security;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.model.Admin;
import com.cts.project.trainReservation.model.PassengerDetails;
import com.cts.project.trainReservation.model.Token;
import com.cts.project.trainReservation.repository.AdminSpingRepository;
import com.cts.project.trainReservation.repository.PassengerDetailsRepository;

@Service
public class AuthenticationService {
	
	private final PassengerDetailsRepository repository;
	private final AdminSpingRepository adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(PassengerDetailsRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AdminSpingRepository adminRepo,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
		this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(PassengerDetails request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }
        
        PassengerDetails user = new PassengerDetails();
        
	        user.setUsername(request.getUsername());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        
	        user.setEmail(request.getEmail());
	        user.setAddress(request.getAddress());
	        user.setAge(request.getAge());
	        user.setBirthDate(request.getBirthDate());
	        user.setGender(request.getGender());
	        user.setMobileNo(request.getMobileNo());
	        user.setRole(request.getRole());
	        
	        user = repository.save(user);

 

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(PassengerDetails request) {
    	
    	try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    	}
    	catch(AuthenticationException e){
    		throw new BadCredentialsException("Invalid Login");
    	}

        PassengerDetails user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful");

    }
    private void revokeAllTokenByUser(PassengerDetails user) {
        List<Token> validTokens = tokenRepository.findAllTokensByPassengerDetails(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, PassengerDetails user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }
}
