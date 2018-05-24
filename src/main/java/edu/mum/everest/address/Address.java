package edu.mum.everest.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private Long id;
	
	@NotEmpty(message="{NotEmpty.valid}")
	@Column(name="line1")
	private String line1;
	
	@Column(name="line2")
	private String line2;
	
	@NotEmpty(message="{NotEmpty.valid}")
	@Column(name="city")
	private String city;
	
	@NotEmpty(message="{NotEmpty.valid}")
	@Column(name="state")
	private String state;
	
	@NotEmpty(message="{NotEmpty.valid}")
	@Column(name="zipcode")
	private String zipcode;
	
	@NotEmpty(message="{NotEmpty.valid}")
	@Column(name="country")
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
