package com.cts.project.trainReservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.trainReservation.Dto.LoginDetails;
import com.cts.project.trainReservation.exception.UserNotFoundException;
import com.cts.project.trainReservation.model.PassengerDetails;
import com.cts.project.trainReservation.service.PassengerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "http://localhost:4200/")
public class PassengerController {
	
	@Autowired
	PassengerService service;
	
	
	@GetMapping("/count")
	@CrossOrigin(origins = "http://localhost:4200/")
	public long totalCountOfPassenger() {
		return service.countOfPassenger();
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200/")
	public PassengerDetails retriveByEmailAndPassword(@RequestBody LoginDetails loginDetails) {
		return service.getByEmailAndPassword(loginDetails);
	}
	
	@GetMapping("/gender/{gender}")
	public List<PassengerDetails> retrieveInfoBasedOnGender(@PathVariable String gender){
		
		return service.findByGender(gender);
	}
	
	@GetMapping("/all")
	public List<PassengerDetails> retrieveAll(){
		return service.FindAll();
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200/")
	public PassengerDetails addDetails(@RequestBody @Valid PassengerDetails passgenger) {
		return service.createDetails(passgenger);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public PassengerDetails updateDetails(@RequestBody PassengerDetails passgenger, @PathVariable int id) {
		return service.updateDetails(passgenger);
	}
	
	@GetMapping("/{id}")
	public Optional<PassengerDetails> findById(@PathVariable int id) {
		Optional<PassengerDetails> passenger = service.findByid(id);
		
		return passenger;
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAll() {
		service.deleteAll();
	}
}
