package com.cts.project.trainReservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "route")
public class RouteDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer routeid;
	
	private String source;
	
	private String destination;
	
	@ManyToOne
	private TrainDetails train;
		
	public TrainDetails getTrain() {
		return train;
	}

	public void setTrain(TrainDetails train) {
		this.train = train;
	}

	public RouteDetails() {}

	public RouteDetails(Integer routeid, String source, String destination) {
		super();
		this.routeid = routeid;
		this.source = source;
		this.destination = destination;
	}

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "RouteDetails [routeid=" + routeid + ", source=" + source + ", destination=" + destination + ", train="
				+ train + "]";
	}

}