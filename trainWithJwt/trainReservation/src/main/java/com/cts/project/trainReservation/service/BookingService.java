package com.cts.project.trainReservation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.exception.DetailsNotFoundException;
import com.cts.project.trainReservation.model.Booking;
import com.cts.project.trainReservation.model.PassengerDetails;
import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.repository.BookingRepository;
import com.cts.project.trainReservation.repository.PassengerDetailsRepository;
import com.cts.project.trainReservation.repository.TrainDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class BookingService {
	
	@Autowired
	PassengerDetailsRepository passengerDetailsRepository;
	
	@Autowired
	TrainDetailsRepository trainDetailsRepository;
	
	@Autowired
	BookingRepository repo;
	
	@Autowired
	EntityManager em;
	
	public Long totalCount() {
		return repo.count();
	}
	
	public String save(Booking booking) {
		//generating pnr
		Random random = new Random(); 
        long num = Math.abs(random.nextLong()); 
        String pnrString = Long.toString(num); 
        String pnr = pnrString.substring(0, 10);
        booking.setPnr(pnr);
        
        //generate seat
        String seats = pnrString.substring(0, booking.getSeatsRequired());
        char arr[] = seats.toCharArray();
        StringBuilder seatNos = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			if(i!=booking.getSeatsRequired()-1) {
				if(arr[i]==0) {
					seatNos.append(arr[i]+1).append(",");
				}
				else if(arr[i] == arr[i+1]) {
					seatNos.append(arr[i]+1).append(",");
				}
				else {
					seatNos.append((arr[i])).append(",");
				}
			}
			else {
				seatNos.append(arr[i]);
				break;
			}
		}
		
		booking.setSeatNumbers(seatNos.toString());
       
        repo.save(booking);
        TrainDetails trainDetails =trainDetailsRepository.findById(booking.getTrain().getTrainId()).get();
        trainDetails.setCapacity(trainDetails.getCapacity() - booking.getSeatsRequired());
        trainDetailsRepository.save(trainDetails);
        PassengerDetails p=passengerDetailsRepository.findById(booking.getPassenger().getId()).get();
        booking.setPassenger(p);
		
		return "Booking successfull";
	}
	
	public Optional<Booking> findByid(int id){
		return repo.findById(id);
	}
	
	public List<Booking> findall(){
		return repo.findAll();
	}
	
	public void deleteBooking(int id) {
		repo.deleteById(id);
	}
	
	public Optional<Booking> findByPnr(String pnr) {
		return repo.findByPNR(pnr);
	}
	
	public String cancelTicket(String pnr) {
		
		Optional<Booking> book = repo.findByPnr(pnr);
		
		if(book.isEmpty()) {
			throw new DetailsNotFoundException("PNR is Invalid");
		}
//		Booking books = new Booking();
		TrainDetails trainDetails =trainDetailsRepository.findById(book.get().getTrain().getTrainId()).get();
	    trainDetails.setCapacity(trainDetails.getCapacity() + book.get().getSeatsRequired());
	    trainDetailsRepository.save(trainDetails);
	    repo.deleteById(book.get().getBookingId());
	    return "Ticket Cancelled Successfully";
	}

	public Booking bookingByPassengerId(int trainid) {
		TrainDetails train = trainDetailsRepository.findById(trainid).get();
		
		List<Booking> booking = repo.findAll();
		
		Booking book = null;
		
		for(int i=0;i<repo.count();i++) {
			if(trainid == booking.get(i).getTrain().getTrainId()) {
				book = booking.get(i);
				break;
			}
		}
		return book;
	}
}
