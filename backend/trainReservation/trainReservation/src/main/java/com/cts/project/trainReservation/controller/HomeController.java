package com.cts.project.trainReservation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.service.HomeDetailsService;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200/")
public class HomeController {
	
	@Autowired
	HomeDetailsService service;
	
	@GetMapping("/classes/{classes}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<TrainDetails> filterTrainByClasses(@PathVariable String classes){
		return service.filterTrain(classes);
	}
	
	
	@GetMapping("/route/{source}/{destination}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<TrainDetails> filterByRoutes(@PathVariable String source, @PathVariable String destination){
		return service.filterByTrainRoute(source, destination);
	}
	
	@GetMapping("/filter/{source}/{destination}/{classes}/{date}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Set<TrainDetails> filterTrains(@PathVariable String source,@PathVariable String destination,@PathVariable String classes,@PathVariable  LocalDate date){
		return service.filterTrains(source, destination, classes, date);
	}
	
	
//	@GetMapping("/filter/{source}/{destination}/{classes}")
//	@CrossOrigin(origins = "http://localhost:4200/")
//	public Set<TrainDetails> filterTrains(@PathVariable String source,@PathVariable String destination,@PathVariable String classes){
//		return service.filterTrains(source, destination, classes);
//	}
}
