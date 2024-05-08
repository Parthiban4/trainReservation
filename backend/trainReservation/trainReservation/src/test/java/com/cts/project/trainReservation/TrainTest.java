package com.cts.project.trainReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.service.TrainService;


@SpringBootTest
class TrainTest {
	
	@Autowired
	TrainService trainService;

	@Test
	void findByIdtest() {
		assertNotNull(trainService.findByid(3));
	}
	
	@Test
	void findAllRoute() {
		assertNotNull(trainService.findall());
	}

}
