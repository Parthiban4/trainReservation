package com.cts.project.trainReservation.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cts.project.trainReservation.repository.PassengerDetailsRepository;

@Component
public class PassengerDetailsServiceImp implements UserDetailsService{
	
	private final PassengerDetailsRepository repository;

    public PassengerDetailsServiceImp(PassengerDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
