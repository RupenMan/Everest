package edu.mum.everest.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	
	@NotEmpty(message = "{NotEmpty.valid}")
	@Size(min=2, max=30,message="{Size.name.valid}")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "{NotEmpty.valid}")
	@Size(min=2, max=30,message="{Size.name.valid}")
	@Column(name="last_name")
	private String lastName;
	
	@Email(message="{Email.valid}")
	@Column(name="email")
	private String email;
	
	@Pattern(regexp="\\d{3}-\\d{3}-\\d{4}", message="{Phone.valid}")
	@Column(name="phone")
	private String phone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
