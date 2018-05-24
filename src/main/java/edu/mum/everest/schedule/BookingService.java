package edu.mum.everest.schedule;

public interface BookingService {
	
	public void saveBooking(Booking booking);
	
	public Booking findBookingById(Long id);
	
	public void cancelBooking(Booking booking);
	
	public void updateBooking(Booking booking);

	/**
	 * @param bookingId
	 * @return
	 */
	public Booking findOne(Long bookingId);
}
