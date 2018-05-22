package edu.mum.everest.schedule;

import org.springframework.stereotype.Repository;

import edu.mum.everest.shared.GenericDaoImpl;

@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao{
	
	public BookingDaoImpl() {
		super.setDaoType(Booking.class);
	}

}
