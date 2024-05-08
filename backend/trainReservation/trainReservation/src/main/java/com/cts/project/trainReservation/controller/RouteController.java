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
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.trainReservation.exception.DetailsNotFoundException;
import com.cts.project.trainReservation.model.RouteDetails;
import com.cts.project.trainReservation.service.RouteService;

@RestController
@RequestMapping("/route")
@CrossOrigin(origins = "http://localhost:4200/")
public class RouteController {
	
	@Autowired
	RouteService service;
	
	@GetMapping("/{id}")
	public Optional<RouteDetails> retrieveById(@PathVariable int id){
		Optional<RouteDetails> route = service.findByid(id);
				
		return route;
	}
	
	@GetMapping("/all")
	public List<RouteDetails> retrieveAll(){
		return service.findall();
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200/")
	public RouteDetails createRoute(@RequestBody RouteDetails route) {
		return service.save(route);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public RouteDetails updateRoute(@RequestBody RouteDetails route,@PathVariable int id) {
		return service.save(route);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public void deleteId(@PathVariable int id) {
		service.deleteByid(id);
	}
	
}
