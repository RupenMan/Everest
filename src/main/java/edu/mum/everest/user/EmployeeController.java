/**
 * 
 */
package edu.mum.everest.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jeewa
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value= "", method = RequestMethod.GET)
	public String getMountaineer(@ModelAttribute ("newEmployee") Employee toBeSaveEmployee) {
		return "registeremployee";
	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public String saveMountaineer(@Valid @ModelAttribute ("newEmployee") Employee toBeSaveEmployee,
			BindingResult result) {
		if(result.hasErrors()) {
			return "registeremployee";
		}
		
		employeeService.saveEmployee(toBeSaveEmployee);
		return "success";
	}
	
}
