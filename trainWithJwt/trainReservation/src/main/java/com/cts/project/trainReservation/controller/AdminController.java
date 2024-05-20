package com.cts.project.trainReservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.trainReservation.exception.UserNotFoundException;
import com.cts.project.trainReservation.model.Admin;
import com.cts.project.trainReservation.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/count")
	public long countOfAdmin() {
		return service.adminCount();
	}
	
	@GetMapping("/{id}")
	public Optional<Admin> retrieveById(@PathVariable int id) {
		Optional<Admin> admin = service.findByid(id);
		
		if(admin.isEmpty()) {
			throw new UserNotFoundException("id not found: "+id);
		}
		
		return admin;
	}
	
	@PostMapping("/add")
	public Admin createuser(@RequestBody @Valid Admin admin) {
		return service.createUser(admin);
	}
	
	@GetMapping("/all")
	public List<Admin> retrieveAll(){
		return service.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable int id) {
		service.deleteByid(id);
	}
}
