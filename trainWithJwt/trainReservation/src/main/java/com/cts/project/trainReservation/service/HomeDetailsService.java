package com.cts.project.trainReservation.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.model.RouteDetails;
import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.repository.RouteDetailsRepository;
import com.cts.project.trainReservation.repository.TrainDetailsRepository;

@Service
public class HomeDetailsService {
	
	@Autowired
	TrainDetailsRepository trainRepo;
	
	@Autowired
	RouteDetailsRepository routeRepo;
//	
//	@Autowired
//	HomePageDetailsRepository homeRepo;
	
		
	public List<TrainDetails> filterByTrainRoute(String source, String destination){
		List<TrainDetails> trainList = new ArrayList<>();
		List<RouteDetails> route = routeRepo.findBySourceAndDestination(source,destination);
		for(int i=0;i<route.size();i++) {
	        trainList.add(trainRepo.findById(route.get(i).getTrain().getTrainId()).get());
		}
	    return trainList;
	}
	
	public List<TrainDetails> filterTrain(String classes){
	    List<TrainDetails> allTrains = trainRepo.findAll();
	    List<TrainDetails> trainList = new ArrayList<>();
	    
	    for(TrainDetails train : allTrains) {
	        String arr[] = train.getTrainClass().split(",");
	        for(String trainClass : arr) {
	            if(trainClass.equals(classes)) {
	                trainList.add(train);
	            }
	        }
	    }

	    return trainList;
	}
	
	public Set<TrainDetails> filterTrains(String source, String destination, String classes){
		
	    List<TrainDetails> trainListByRoute = filterByTrainRoute(source, destination);

	    List<TrainDetails> trainListByClass = filterTrain(classes);

	    Set<TrainDetails> finalTrainList = new HashSet<>();
	    
		    for(TrainDetails trainByRoute : trainListByRoute) {
		        for(TrainDetails trainByClass : trainListByClass) {
		            if(trainByRoute.getTrainId() == trainByClass.getTrainId()) {
		                finalTrainList.add(trainByRoute);
		                break;
		            }
		        }
		    }

	    return finalTrainList;
	}




}
