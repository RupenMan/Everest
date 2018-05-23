/**
 * 
 */
package edu.mum.everest.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edu.mum.everest.company.TravelAgency;
import edu.mum.everest.schedule.Schedule;

/**
 * @author jeewa
 *
 */
@Entity(name = "employee")
public class Employee extends User{
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TravelAgency travelAgency;
	
	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

}
