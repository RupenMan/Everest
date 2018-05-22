package edu.mum.everest.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDao bookingDao;
	@Override
	public void saveBooking(Booking booking) {
		bookingDao.save(booking);
	}

	@Override
	public void cancelBooking(Booking booking) {
		bookingDao.delete(booking.getId());
	}

	@Override
	public Booking findBookingById(Long id) {
		return bookingDao.findOne(id);
	}

}
