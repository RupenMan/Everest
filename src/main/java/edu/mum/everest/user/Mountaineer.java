package edu.mum.everest.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.everest.schedule.Booking;

@Entity
@Table(name = "MOUNTAINEER")
public class Mountaineer extends User {

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@OneToOne(mappedBy = "mountaineer", cascade = { CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Booking booking;

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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
