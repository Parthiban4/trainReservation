package com.cts.project.trainReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.repository.BookingRepository;
import com.cts.project.trainReservation.service.BookingService;

@SpringBootTest
class BookingTest {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingRepository bookingRepo; 

	@Test
	void findByPNRtest() {
		assertNotNull(bookingService.findByPnr("2547431503"));
	}
	
	@Test
	void findByBookingIdtest() {
		assertNotNull(bookingRepo.findById(135656));
	}
	
	@Test
	void findBookingCounttest() {
		assertEquals(2, bookingRepo.count());
	}
	
	@Test
	void cancelTickettest() {
		assertEquals("Ticket Cancelled Successfully",bookingService.cancelTicket("2547431503"));
	}
	

}
