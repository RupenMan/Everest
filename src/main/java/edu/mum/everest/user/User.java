package edu.mum.everest.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.everest.address.Address;


@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
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
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserCredentials userCredential;
	
	@Valid
	@OneToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="address_id")
	private List<Address> addressList= new ArrayList<Address>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public void addAddress(Address address) {
		this.addressList.add(address);
	}
}
