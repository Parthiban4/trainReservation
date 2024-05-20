package com.cts.project.trainReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.model.RouteDetails;
import com.cts.project.trainReservation.repository.RouteDetailsRepository;

@Service
public class RouteService {
	
	@Autowired
	RouteDetailsRepository repo;
	
	
	public RouteDetails save(RouteDetails route) {
		return repo.save(route);
	}
	
	public RouteDetails updateRoute(RouteDetails route) {
		return repo.save(route);
	}
	
	public Optional<RouteDetails> findByid(int id){
		return repo.findById(id);
	}
	
	public List<RouteDetails> findall(){
		return repo.findAll();
	}
	
	public void deleteByid(int id) {
		repo.deleteById(id);
	}
}
