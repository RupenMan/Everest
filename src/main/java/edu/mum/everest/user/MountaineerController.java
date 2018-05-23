package edu.mum.everest.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.everest.schedule.Booking;

@Controller
@RequestMapping("/mountaineer")
public class MountaineerController {

	@Autowired
	private MountaineerService mountaineerService;

	@RequestMapping("/homepage")
	public String homePage() {
		return "mountaineer_homepage";
	}

	@RequestMapping(value = "/selector", method = RequestMethod.POST)
	public String selector(@Valid @ModelAttribute("newMountaineer") Mountaineer saveMountaineer,
			@RequestParam("id") String id, BindingResult result) {

		if (result.hasErrors()) {
			return "addMountaineer";
		} else {
			if (saveMountaineer.getId() == null) {
				return saveMountaineer(saveMountaineer);
			} else {
				Mountaineer oldClimber = mountaineerService.findMountaineerById(Long.parseLong(id));
				Booking myBooking = oldClimber.getBooking();
				saveMountaineer.setBooking(myBooking);
				return updateMountaineer(saveMountaineer);
			}
		}
	}

	@RequestMapping(value = "/addMountaineer", method = RequestMethod.GET)
	public String addMountaineer(@ModelAttribute("newMountaineer") Mountaineer newMountaineer, Model model) {
		try {
			Mountaineer mountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
			model.addAttribute("mountaineer", mountaineer);
			return "addMountaineer";
		} catch (Exception ex) {
			model.addAttribute("mountaineer", new Mountaineer());
			return "addMountaineer";
		}
	}

	public String saveMountaineer(Mountaineer newMountaineer) {
		mountaineerService.saveMountaineer(newMountaineer);
		return "success";
	}

	public String updateMountaineer(Mountaineer updateMountaineer) {
		mountaineerService.updateMountaineer(updateMountaineer);
		return "success";
	}

	@RequestMapping(value = "/viewMountaineerInfo", method = RequestMethod.GET)
	public String viewInfo(Model model) {
		Mountaineer activeMountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
		model.addAttribute("mountaineer", activeMountaineer);
		return "viewMountaineerInfo";
	}
}
