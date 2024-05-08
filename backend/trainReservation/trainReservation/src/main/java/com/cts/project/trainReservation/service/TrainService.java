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
import com.cts.project.trainReservation.exception.UserNotFoundException;
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
	
	
	public TrainDetails save(TrainDetails train) {
		return repo.save(train);
	}
	
	public TrainDetails updatetrain(TrainDetails train) {
		return repo.save(train);
	}
	
	public Optional<TrainDetails> findByid(int id){
		Optional<TrainDetails> train = repo.findById(id);
		
		if(train.isEmpty()) {
			throw new DetailsNotFoundException("train id is invalid:"+id);
		}
		return train;
	}
	
	public List<TrainDetails> findall(){
		return repo.findAll();
	}
	
	public void deleteByid(int id) {
		if(id == 0) {
			throw new UserNotFoundException("Id must not be equal to 0");
		}
		repo.deleteById(id);
	}
}
