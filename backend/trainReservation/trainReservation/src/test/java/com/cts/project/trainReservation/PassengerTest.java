package com.cts.project.trainReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.service.PassengerService;

@SpringBootTest
class PassengerTest {
	
	@Autowired
	PassengerService passengerService;

	@Test
	void findByIdtest() {
		assertNotNull(passengerService.findByid(1));
	}
	
	
	@Test
	void findBookingCounttest() {
		assertEquals(2, passengerService.countOfPassenger());
	}
	
	@Test
	void findAllPassenger() {
		assertNotNull(passengerService.FindAll());
	}
	


}
