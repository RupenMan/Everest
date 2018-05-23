package edu.mum.everest.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.aspect.Logging;
import edu.mum.everest.user.MountaineerDao;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired 
	private MountaineerDao mountaineerDao;
	
	@Logging
	@Override
	public void saveBooking(Booking booking) {
		bookingDao.save(booking);
	}

	@Logging
	@Override
	public void cancelBooking(Booking booking) {
//		bookingDao.delete(booking.getId());
		bookingDao.deleteBookById(booking.getId());
	}

	public void updateBooking(Booking booking) {
		bookingDao.update(booking);
	}
	
	@Override
	public Booking findBookingById(Long id) {
		return bookingDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see edu.mum.everest.schedule.BookingService#findOne(java.lang.Long)
	 */
	@Override
	public Booking findOne(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
