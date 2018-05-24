package edu.mum.everest.authentication;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.everest.email.EmailGateway;
import edu.mum.everest.email.EmailMessage;
import edu.mum.everest.email.EmailMessageBuilder;
import edu.mum.everest.email.UserActivation;
import edu.mum.everest.email.dao.UserActivationDao;
import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.User;
import edu.mum.everest.user.UserCredentials;

@Controller
@RequestMapping(value = {"", "/login"})
public class LoginController {
	
	@Autowired
	private PersonsService personsService;
	
	@Autowired
	private EmailGateway emailGateway;
	
	@Autowired
	private UserActivationDao userActivationDao;
	 
	
	private UserCredentials globalUser = new UserCredentials();
	
	@RequestMapping("/register")
	public String register() {
		return "registerAccount";
	}
	
	@RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
	public String login(@ModelAttribute("getUser") User newUser, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/saveMountaineer", method=RequestMethod.POST)
	public String saveMountaineer(@ModelAttribute("getUser") UserCredentials userCredentials,Model model) { 
		UserCredentials checkUsername = personsService.checkUsername(userCredentials);
		System.out.println(checkUsername);
		if (checkUsername != null && checkUsername.getPassword() == null && checkUsername.getEnable() == 0) {
			model.addAttribute("mountaineer", new UserCredentials());
			model.addAttribute("logActivate","logActivate");
			return "login";
		} else if (checkUsername != null && checkUsername.getPassword() == null && checkUsername.getEnable() == 1) {
			globalUser.setId(checkUsername.getId());
			globalUser.setEnable(checkUsername.getEnable());
			globalUser.setUsername(checkUsername.getUsername());
			return "updatePassword";
		} else if (checkUsername != null && checkUsername.getPassword() != null && checkUsername.getEnable() == 1) {
			UserCredentials newuserCredentials = personsService.authenticationLogin(userCredentials);
			if (newuserCredentials != null) {
				model.addAttribute("person", newuserCredentials);
				return "mountaineer_homepage";
			} else {
				model.addAttribute("mountaineer", new UserCredentials());
				model.addAttribute("logError","logError");
				return "login";
			}
		} else {
			model.addAttribute("mountaineer", new UserCredentials());
			model.addAttribute("logError","logError");
			return "login";
		}
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("newUser") UserCredentials userCredentials,Model model) { 	
		UserCredentials checkUsername = personsService.checkUsername(userCredentials);
		
		if (checkUsername == null) {
			personsService.register(userCredentials);
			model.addAttribute("emailCheck","emailCheck");
			
			personsService.sendEmail(userCredentials);
			
			
			return "login";
		} else {
			model.addAttribute("emailCheck","emailCheck");
			
			
			return "registerAccount";
		}
	}
	
	
	
	@RequestMapping(value = "/registerPassword", method = RequestMethod.POST)
	public String registerPassword(@Valid @ModelAttribute("newUser") UserCredentials userCredentials, BindingResult result) {
		if (result.hasErrors()) {
			return "registerAccount";
		}
		globalUser.setPassword(userCredentials.getPassword());
		personsService.updatePassword(globalUser);
		return "mountaineer_homepage";
	}
	
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("admin");
//
//		return model;
//
//	}
//	
//	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
//    public String accessDeniedPage(ModelMap model) {
//        model.addAttribute("user", getPrincipal());
//        return "accessDenied";
//    }
//	
//	private String getPrincipal(){
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
// 
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails)principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
}