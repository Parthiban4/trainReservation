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
import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.service.TrainService;

@RestController
@RequestMapping("/train")
@CrossOrigin(origins = "http://localhost:4200/")
public class TrainController {
	
	@Autowired
	TrainService service;
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Optional<TrainDetails> retrieveById(@PathVariable int id){
		Optional<TrainDetails> train =  service.findByid(id);
		return train;
	}
	
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<TrainDetails> retrieveAll(){
		return service.findall();
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200/")
	public TrainDetails createTrain(@RequestBody TrainDetails route) {
		return service.save(route);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public TrainDetails updateTrain(@RequestBody TrainDetails route,@PathVariable int id) {
		return service.updatetrain(route);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public void deleteId(@PathVariable int id) {
		service.deleteByid(id);
	}
	
}
