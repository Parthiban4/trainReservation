package com.cts.project.trainReservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.cts.project.trainReservation.repository.AdminRepository;
import com.cts.project.trainReservation.repository.AdminSpingRepository;
import com.cts.project.trainReservation.service.PassengerService;

@SpringBootApplication
public class TrainReservationApplication{


	public static void main(String[] args) {
		SpringApplication.run(TrainReservationApplication.class, args);
	}

}
