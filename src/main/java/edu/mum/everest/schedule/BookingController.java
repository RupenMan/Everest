package edu.mum.everest.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.MountaineerService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private MountaineerService mountaineerService;

	@Autowired
	private ScheduleService scheduleSerive;
	
	@RequestMapping("/saveBooking")
	public String save(@RequestParam("scheduleId") Long toBeBooked) {
		Mountaineer activeMountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
		activeMountaineer.setBooking(new Booking());
		activeMountaineer.getBooking().setStatus("Pending");
		activeMountaineer.getBooking().setBookingDate(new Date());
		activeMountaineer.getBooking().setMountaineer(activeMountaineer);
//		
		Schedule schedule = scheduleSerive.findOne(toBeBooked);
		activeMountaineer.getBooking().setSchedule(schedule);
//		booking.setSchedule(schedule);
		bookingService.saveBooking(activeMountaineer.getBooking());
		return "success";
	}

	@RequestMapping(value = "/viewBookingInfo", method = RequestMethod.GET)
	public String viewBooking(Model model) {
		try {
			Mountaineer activeMountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
			Booking myBooking = activeMountaineer.getBooking();
			model.addAttribute("booking", myBooking);
			return "viewBookingInfo";
		} catch (Exception ex) {
			model.addAttribute("booking", new Booking());
			return "viewBookingInfo";
		}
	}

	@RequestMapping("/cancelBooking")
	public String delete() {
		Mountaineer activeMountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
		Booking myBooking = activeMountaineer.getBooking();
		activeMountaineer.setBooking(null);
		bookingService.cancelBooking(myBooking);
		return "success";
	}

}
