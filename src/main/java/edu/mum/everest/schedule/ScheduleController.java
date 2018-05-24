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

	@RequestMapping(value = "/bookschedule", method = RequestMethod.GET)
	public String bookSchedule(Model model) {
		// if (id != null) {
		// Schedule schedule = scheduleService.findOne(id);
		// model.addAttribute("newSchedule", schedule);
		// }
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		return "bookschedule";
	}

	@RequestMapping(value = "/addschedule", method = RequestMethod.GET)
	public String addSchedule(Model model, @ModelAttribute("newSchedule") Schedule toBeSaveSchedule) {
		model.addAttribute("submitBtnValue", "Add");
		model.addAttribute("title", "Add a new Schedule");
		return "addschedule";
	}

	@RequestMapping(value = "/updateschedule", method = RequestMethod.GET)
	public String updateSchedule(Model model, @RequestParam("id") Long id) {
		Schedule schedule = scheduleService.findOne(id);
		model.addAttribute("newSchedule", schedule);
		model.addAttribute("submitBtnValue", "Update");
		model.addAttribute("title", "Update Schedule");
		return "addschedule";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		return "schedules";
	}

	@RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("newSchedule") Schedule toBeSaveSchedule, BindingResult result) {
		if (result.hasErrors()) {
			return "addschedule";
		}
		if (toBeSaveSchedule.getId() == null) {
			scheduleService.saveSchedule(toBeSaveSchedule);
		} else {
			scheduleService.updateSchedule(toBeSaveSchedule);
		}
		return "redirect:/schedule/all";
	}
}
