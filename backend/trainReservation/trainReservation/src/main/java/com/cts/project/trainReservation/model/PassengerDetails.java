package com.cts.project.trainReservation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="passenger")
public class PassengerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Email(message = "Email is not valid")
	private String email;
	
	@Size(min = 3,message="UserName must have atleast of 3 letters")
	private String username;
	
	private String password;
	
	private String address;
	
	@Past
	private LocalDate birthdate;
	
	private int age;
	
	private String gender;
	
	private long mobileno;
	
	@JsonIgnore
	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
	private List<Booking> booking = new ArrayList<>();
	
	
	
	protected PassengerDetails() {
		
	}
	
	public PassengerDetails(int id,String email, String username, String password, String address, int age,
			String gender,long mobileno) {
		super();
		this.id=id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.age = age;
		this.mobileno=mobileno;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthDate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "PassengerDetails [id=" + id +", email=" + email + ", username=" + username
				+ ", password=" + password + ", address=" + address +", mobileno="+ mobileno +", age=" + age + ", gender=" + gender + "]";
	}
	
}
