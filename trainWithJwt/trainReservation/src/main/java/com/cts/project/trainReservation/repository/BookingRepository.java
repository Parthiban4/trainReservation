package com.cts.project.trainReservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.project.trainReservation.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query(value="select * from booking where pnr = ?1",nativeQuery = true)
	public Optional<Booking> findByPNR(String pnr);

	public Optional<Booking> findByPnr(String pnr);
}
