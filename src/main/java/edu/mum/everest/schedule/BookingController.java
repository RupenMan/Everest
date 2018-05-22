package edu.mum.everest.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/saveBooking")
	public String save() {
		Booking booking = new Booking();
		booking.setStatus("Pending");
		booking.setBookingDate(new Date());
		bookingService.saveBooking(booking);
		return "success";
	}
	
	@RequestMapping("/cancelBooking")
	public String delete() {
		Booking booking = bookingService.findBookingById(1L);
		bookingService.cancelBooking(booking);
		return "success";
	}
	
}
