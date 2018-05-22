package edu.mum.everest.schedule;

import edu.mum.everest.shared.GenericDao;

public interface BookingDao extends GenericDao<Booking> {
	
	@Override
	public void save(Booking booking);
	
	@Override
	public void delete(Long id);
}
