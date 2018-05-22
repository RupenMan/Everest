package edu.mum.everest.schedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.everest.user.Mountaineer;


@Entity
@Table(name = "BOOKING")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private long id;

	@Column(name="status")
	private String status;

	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@OneToOne
	@JoinColumn(name = "mountaineer_id")
	private Mountaineer mountaineer;
	
//	@ManyToOne
//	@JoinTable(name="booking_schedule", joinColumns= {@JoinColumn(name="booking_id")}, 
//		inverseJoinColumns = {@JoinColumn(name="schedule_id")})
//	private Schedule schedule;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Mountaineer getMountaineer() {
		return mountaineer;
	}

	public void setMountaineer(Mountaineer mountaineer) {
		this.mountaineer = mountaineer;
	}
}
