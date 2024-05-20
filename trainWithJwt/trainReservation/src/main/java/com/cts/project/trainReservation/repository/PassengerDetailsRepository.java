package com.cts.project.trainReservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.trainReservation.model.PassengerDetails;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Integer>{
	
	Optional<PassengerDetails> findByUsername(String username);
}
