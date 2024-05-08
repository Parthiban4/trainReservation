package com.cts.project.trainReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.service.RouteService;

@SpringBootTest
class RouteTest {
	
	@Autowired
	RouteService routeService;

	@Test
	void findByIdtest() {
		assertNotNull(routeService.findByid(3));
	}
	
	@Test
	void findAllRoute() {
		assertNotNull(routeService.findall());
	}

}
