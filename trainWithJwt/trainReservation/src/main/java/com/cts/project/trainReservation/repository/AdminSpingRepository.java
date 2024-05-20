package com.cts.project.trainReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.project.trainReservation.model.Admin;

@Repository
public interface AdminSpingRepository extends JpaRepository<Admin,Integer> {
	
	
//	@Query(value = "select * from admin where email like '%com'", nativeQuery=true)
//	List<Admin> findBy_Email_EndWith_com();
}
