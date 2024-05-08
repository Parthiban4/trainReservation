package com.cts.project.trainReservation.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.trainReservation.exception.DetailsNotFoundException;
import com.cts.project.trainReservation.exception.UserNotFoundException;
import com.cts.project.trainReservation.model.Booking;
import com.cts.project.trainReservation.model.PassengerDetails;
import com.cts.project.trainReservation.model.TrainDetails;
import com.cts.project.trainReservation.repository.BookingRepository;
import com.cts.project.trainReservation.repository.PassengerDetailsRepository;
import com.cts.project.trainReservation.repository.TrainDetailsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingService {
	
	@Autowired
	PassengerDetailsRepository passengerDetailsRepository;
	
	@Autowired
	TrainDetailsRepository trainDetailsRepository;
	
	@Autowired
	BookingRepository repo;
	
	
	public Long totalCount() {
		return repo.count();
	}
	
	public String save(Booking booking) {
		if(booking == null) {
			throw new DetailsNotFoundException("Booking Details not found");
		}

		//generating pnr
		Random random = new Random(); 
        long num = Math.abs(random.nextLong()); 
        String pnrString = Long.toString(num); 
        String pnr = pnrString.substring(0, 10);
        booking.setPnr(pnr);
        
        
        //generate random seats
        Random rand = new Random();
        Set<String> seatNos = new HashSet<>();
        int start = 10;
        int end = 200;
        int seatsRequired = booking.getSeatsRequired();

        while (seatNos.size() < seatsRequired) {
	        int result = Math.abs(rand.nextInt(end - start) + start);
	        if(result%2==0) {
	        	String s = result+"";
	        	
	        	seatNos.add(s+"(W)");
	        }
	        else {
	        	String s = result+"";
	        	seatNos.add(s);
	        }
        }

		booking.setSeatNumbers(seatNos.toString());
       
        repo.save(booking);
        TrainDetails trainDetails =trainDetailsRepository.findById(booking.getTrain().getTrainid()).get();
        trainDetails.setCapacity(trainDetails.getCapacity() - booking.getSeatsRequired());
        trainDetailsRepository.save(trainDetails);
        PassengerDetails p=passengerDetailsRepository.findById(booking.getPassenger().getId()).get();
        booking.setPassenger(p);
		
		return "Booking successfull";
	}
	
	public Optional<Booking> findByid(int id){
		if(id == 0) {
			throw new UserNotFoundException("Id should not be equal to 0");
		}
		return repo.findById(id);
	}
	
	public List<Booking> findall(){
		return repo.findAll();
	}
	
	public void deleteBooking(int id) {
		if(id == 0) {
			throw new UserNotFoundException("Id should not be equal to 0");
		}
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
		TrainDetails trainDetails =trainDetailsRepository.findById(book.get().getTrain().getTrainid()).get();
	    trainDetails.setCapacity(trainDetails.getCapacity() + book.get().getSeatsRequired());
	    trainDetailsRepository.save(trainDetails);
	    repo.deleteById(book.get().getBookingId());
	    return "Ticket Cancelled Successfully";
	}

	public Booking bookingByTrainId(int trainid) {
		
		List<Booking> booking = repo.findAll();
		
		Booking book = null;
		
		for(int i=(int)repo.count()-1;i>=0;i--) {
			if(trainid == booking.get(i).getTrain().getTrainid()) {
				book = booking.get(i);
				break;
			}
		}
		return book;
	}
}
