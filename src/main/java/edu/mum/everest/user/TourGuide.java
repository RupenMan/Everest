/**
 * 
 */
package edu.mum.everest.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author jeewa
 *
 */
@Entity(name = "tour_guide")
public class TourGuide {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="guid_id")
	private long id;
	
	@Column(length = 32)
	private String name;
}
