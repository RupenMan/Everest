/**
 * 
 */
package edu.mum.everest.schedule;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jeewa
 *
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;

	@RequestMapping(value = "/addschedule", method = RequestMethod.GET)
	public String addSchedule(@ModelAttribute("newSchedule") Schedule toBeSaveSchedule) {
		// if (id != null) {
		// Schedule schedule = scheduleService.findOne(id);
		// model.addAttribute("newSchedule", schedule);
		// }
		return "addschedule";
	}

	@RequestMapping(value = "/updateschedule", method = RequestMethod.GET)
	public String updateSchedule(Model model, @RequestParam("id") Long id) {
		Schedule schedule = scheduleService.findOne(id);
		model.addAttribute("newSchedule", schedule);
		return "addschedule";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("jeewan all");
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		return "schedules";
	}

	@RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("newSchedule") Schedule toBeSaveSchedule, BindingResult result) {
		if (result.hasErrors()) {
			return "addschedule";
		}
		System.out.println("jeewan");
		if (toBeSaveSchedule.getId() == null) {
			System.out.println("jeewan");
			scheduleService.saveSchedule(toBeSaveSchedule);
		}
		else {
			System.out.println("jeewan11");
			scheduleService.updateSchedule(toBeSaveSchedule);
		}
		return "redirect:/schedule/all";
	}
}
