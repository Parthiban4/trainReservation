package com.cts.project.trainReservation.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.project.trainReservation.model.Token;

public interface TokenRepository extends JpaRepository<Token, Integer>{
	
	@Query("""
	 select t from Token t inner join PassengerDetails p on t.user.id = p.id
	 where t.user.id = :userId and t.loggedOut = false
	 """)
	List<Token> findAllTokensByPassengerDetails(Integer userId);

			     Optional<Token> findByToken(String token);
			     
			
}
