package com.cts.project.trainReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.Dto.LoginDetails;
import com.cts.project.trainReservation.exception.DetailsNotFoundException;
import com.cts.project.trainReservation.exception.UserNotFoundException;
import com.cts.project.trainReservation.model.PassengerDetails;
import com.cts.project.trainReservation.repository.PassengerDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class PassengerService {
	
	@Autowired
	PassengerDetailsRepository repo;
	
	@Autowired
	EntityManager em;
	
	//to get count of passenger
	public long countOfPassenger() {
		try {
			return repo.count();
		}
		catch(DetailsNotFoundException e) {
			throw new DetailsNotFoundException("Passenger count is 0");
		}
	}
	
	//to find passenger based on gender
	public List<PassengerDetails> findByGender(String gender){
			Query query = em.createNativeQuery("select * from passenger where gender like ?",PassengerDetails.class);
			
			query.setParameter(1, gender);
			List<PassengerDetails> result = query.getResultList();
			
			if(result.isEmpty()) {
				throw new DetailsNotFoundException("Details not Present");
			}
			
			return result;
	}
	
	//find all users
	public List<PassengerDetails> FindAll(){
		return repo.findAll();
	}
	
	//create new user details
	public PassengerDetails createDetails(PassengerDetails passenger) {
		return repo.save(passenger);
	}
	
	public PassengerDetails updateDetails(PassengerDetails passenger) {
		return repo.save(passenger);
	}
	
	//find user by id
	public Optional<PassengerDetails> findByid(int id) {
		Optional<PassengerDetails> passenger = repo.findById(id);
		if(passenger.isEmpty()) {
			throw new UserNotFoundException("Passenger Not found id:"+id);
		}
		return passenger;
	}
	
	//delete by id
	public void deleteById(int id) {
		if(id == 0) {
			throw new DetailsNotFoundException("Inavlid Id");
		}
		repo.deleteById(id);
	}
	
	//delete all users
	public void deleteAll() {
		repo.deleteAll();
	}

	public PassengerDetails getByEmailAndPassword(LoginDetails login) {
		// TODO Auto-generated method stub
		return repo.getEmailAndPassword(login.getEmail(), login.getPassword());
	}
}
