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
import jakarta.persistence.Table;

@Entity
@Table(name="train")
public class TrainDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainid;
	
	@OneToMany(mappedBy = "train" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Booking> booking = new ArrayList<>();
	
	private String trainname;
	
	private String trainclass;
	
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

	public TrainDetails(int trainid,String trainname, String trainclass, int capacity, LocalDate date,
			LocalTime timing) {
		super();
		this.trainid=trainid;
		this.trainname = trainname;
		this.trainclass = trainclass;
		this.capacity = capacity;
		this.date = date;
		this.timing = timing;
	}

	public int getTrainid() {
		return trainid;
	}

	public void setTrainId(Integer trainid) {
		this.trainid = trainid;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainName(String trainname) {
		this.trainname = trainname;
	}

	public String getTrainclass() {
		return trainclass;
	}

	public void setTrainclass(String trainclass) {
		this.trainclass = trainclass;
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
		return "TrainDetails [trainid=" + trainid + ", booking=" + booking + ", trainname=" + trainname
				+ ", trainclass=" + trainclass + ", capacity=" + capacity + ", date=" + date
				+ ", timing=" + timing + ", route=" + route + "]";
	}

	
	
}
