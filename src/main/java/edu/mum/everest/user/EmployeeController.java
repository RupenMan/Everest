/**
 * 
 */
package edu.mum.everest.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value= "/employeeDashboard", method = RequestMethod.GET)
	public String getEmployeeDashboard(Model model) {
		//try {
		model.addAttribute("employee", employeeService.findEmployeeByUsername("efacjeewan@gmail.com"));
		return "employeedashboard";
		/*}catch(Exception ex) {
			return "employeedashboard";
		}*/
	}
	
	@RequestMapping(value= "/registerEmployee", method = RequestMethod.GET)
	public String registerEmployee(@ModelAttribute ("newEmployee") Employee toBeSaveEmployee) {
		return "registeremployee";
	}
	
	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute ("newEmployee") Employee toBeSaveEmployee,
			BindingResult result) {
		System.out.println("jeewan");
		if(result.hasErrors()) {
			System.out.println("jeewan 11");
			return "registeremployee";
		}
		
		employeeService.saveEmployee(toBeSaveEmployee);
		return "redirect:/schedule/addschedule";
	}
	
}
