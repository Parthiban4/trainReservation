package com.cts.project.trainReservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.trainReservation.model.RouteDetails;

public interface RouteDetailsRepository extends JpaRepository<RouteDetails, Integer>{
	
	List<RouteDetails> findBySourceAndDestination(String source, String destination);
}