package com.cts.project.trainReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.model.Admin;
import com.cts.project.trainReservation.repository.AdminSpingRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminSpingRepository repo;
	
	public long adminCount() {
		return repo.count();
	}
	
	public Optional<Admin> findByid(int id) {
		return repo.findById(id);
	}
	
	
	public Admin createUser(Admin admin) {
		return repo.save(admin);
	}
	
	public List<Admin> findAll(){
		return repo.findAll();
	}
	
	public void deleteByid(int id) {
		repo.deleteById(id);
	}
	
	
}
