package com.cts.project.trainReservation.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
public class TrainDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainId;
	
	@OneToMany(mappedBy = "train" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking = new ArrayList<>();
	
	private String trainName;
	
	private String trainClass;
	
	private int capacity;
	
	private LocalDate date;
	
	private LocalTime timing;
	
	@JsonIgnore
	@OneToMany(mappedBy = "train")
	private List<RouteDetails> route = new ArrayList<>();
	

	public void setRoute(List<RouteDetails> route) {
		this.route = route;
	}

	public TrainDetails() {
		
	}

	public TrainDetails(int trainId,String trainName, String trainClass, int capacity, String coachNo, LocalDate date,
			LocalTime timing) {
		super();
		this.trainId=trainId;
		this.trainName = trainName;
		this.trainClass = trainClass;
		this.capacity = capacity;
		this.date = date;
		this.timing = timing;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainClass() {
		return trainClass;
	}

	public void setTrainClass(String trainClass) {
		this.trainClass = trainClass;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTiming() {
		return timing;
	}

	public void setTiming(LocalTime timing) {
		this.timing = timing;
	}

	public List<RouteDetails> getRoute() {
		return route;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainId=" + trainId + ", booking=" + booking + ", trainName=" + trainName
				+ ", trainClass=" + trainClass + ", capacity=" + capacity + ", date=" + date
				+ ", timing=" + timing + ", route=" + route + "]";
	}

	
	
}
