package com.cts.project.trainReservation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.service.HomeDetailsService;

@SpringBootTest
class HomeServiceTest {
	
	@Autowired
	HomeDetailsService homeService;

	@Test
	void filterByRoutetest() {
		assertNotNull(homeService.filterByTrainRoute("Chennai", "Madurai"));
	}
	
	@Test
	void filterByClassestest() {
		assertNotNull(homeService.filterTrain("All Classes"));
	}
	
	@Test
	void filterByDetails() {
		assertNotNull(homeService.filterTrains("Chennai", "Madurai","AC First Class(1A)", LocalDate.now()));
	}

}
