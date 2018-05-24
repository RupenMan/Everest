package edu.mum.everest.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.everest.email.UserActivation;
import edu.mum.everest.email.service.UserActivationService;

/**
 * 
 * @author netra
 */
@Controller
@RequestMapping("/userActivation")
public class UserActivationController {
	@Autowired
	private UserActivationService userActivationService;
	
	@RequestMapping(name="", method=RequestMethod.GET)
	public String activate(@RequestParam("key") String key) {
		UserActivation user = userActivationService.findByKey(key);
		if(user!=null)
			return "success";
		else 
			return "error";
	}
}
