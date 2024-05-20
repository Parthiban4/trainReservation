package com.cts.project.trainReservation.service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.exception.DetailsNotFoundException;
import com.cts.project.trainReservation.model.Booking;
import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.repository.TrainDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrainService {
	
	@Autowired
	TrainDetailsRepository repo;
	
	@Autowired
	EntityManager em;
	
	public TrainDetails save(TrainDetails train) {
		return repo.save(train);
	}
	
	public TrainDetails updatetrain(TrainDetails train) {
		return repo.save(train);
	}
	
	public Optional<TrainDetails> findByid(int id){
		return repo.findById(id);
	}
	
	public List<TrainDetails> findall(){
		return repo.findAll();
	}
	
	public void deleteByid(int id) {
		repo.deleteById(id);
	}
}
