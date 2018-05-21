package edu.mum.everest.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MOUNTAINEER")
public class Mountaineer extends User {
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
//	@OneToOne(mappedBy="mountaineer", cascade= {CascadeType.PERSIST, CascadeType.MERGE},
//			fetch=FetchType.EAGER)
//	private Booking booking;

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
	
	
}
