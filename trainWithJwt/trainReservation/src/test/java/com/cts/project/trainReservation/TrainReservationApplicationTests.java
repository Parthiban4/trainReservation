package com.cts.project.trainReservation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.trainReservation.model.Admin;
import com.cts.project.trainReservation.service.AdminService;


@SpringBootTest
class TrainReservationApplicationTests {
	
	@Autowired
	AdminService adminService;

	@Test
	void adminCountTest() {
		assertEquals(3, adminService.adminCount());
	}
	
	@Test
	void findByAdminId() {
		int id = 10003;
		Optional<Admin> admin = adminService.findByid(10003);
		assertTrue(admin.isPresent());
		
	}

}
