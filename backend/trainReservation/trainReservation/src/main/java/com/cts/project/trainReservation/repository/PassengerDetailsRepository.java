package com.cts.project.trainReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.project.trainReservation.model.PassengerDetails;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Integer>{
	
	@Query(value = "select * from passenger p where p.email like :email and p.password like :password", nativeQuery = true)
	PassengerDetails getEmailAndPassword(String email, String password);
}
