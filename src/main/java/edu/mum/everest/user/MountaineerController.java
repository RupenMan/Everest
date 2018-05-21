package edu.mum.everest.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mountaineer")
public class MountaineerController {
	
	@Autowired
	private MountaineerService mountaineerService;
	
	@RequestMapping(value= "/addMountaineer", method = RequestMethod.GET)
	public String addMountaineer(@ModelAttribute ("newMountaineer") Mountaineer newMountaineer) {
		return "mountaineer";
	}
	
	@RequestMapping(value="/saveMountaineer", method = RequestMethod.POST)
	public String saveMountaineer(@Valid @ModelAttribute ("newMountaineer") Mountaineer saveMountaineer,
			BindingResult result) {
		if(result.hasErrors()) {
			return "mountaineer";
		}
		
		mountaineerService.saveMountaineer(saveMountaineer);
		return "success";
	}

}
