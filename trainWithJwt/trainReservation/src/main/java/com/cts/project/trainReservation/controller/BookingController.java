package com.cts.project.trainReservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.trainReservation.model.Booking;
import com.cts.project.trainReservation.service.BookingService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200/")
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@GetMapping("/count")
	public Long bookingCount() {
		return service.totalCount();
	}
	
	@GetMapping("/{id}")
	public Optional<Booking> retrieveById(@PathVariable int id){
		return service.findByid(id);
	}
	
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<Booking> retrieveAll(){
		return service.findall();
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200/")
	public String addBooking(@RequestBody Booking booking) {
		return service.save(booking);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteBooking(id);
	}
	
	@DeleteMapping("/cancel/{pnr}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public String cancelticket(@PathVariable String pnr) {
		return service.cancelTicket(pnr);
	}
	
	@GetMapping("/trainId/{trainid}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Booking getBookingByPassengerId(@PathVariable int trainid) {
		return service.bookingByPassengerId(trainid);
	}
}
