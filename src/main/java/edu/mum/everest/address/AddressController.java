package edu.mum.everest.address;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.everest.user.MountaineerService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public String addAddress(@ModelAttribute("newAddress") Address address, Model model) {
		model.addAttribute("address", new Address());
		return "addAddress";
	}

	@RequestMapping(value = "/selector", method = RequestMethod.POST)
	public String selector(@Valid @ModelAttribute("newAddress") Address newAddress, BindingResult result) {

		if (result.hasErrors()) {
			return "addAddress";
		} else {
			if (newAddress.getId() == null) {
				return saveAddress(newAddress);
			} else {
				return updateAddress(newAddress);
			}
		}
	}

	public String saveAddress(Address address) {
		addressService.saveAddress(address);
		return "success";
	}

	public String updateAddress(Address address) {
		addressService.updateAddress(address);
		return "success";
	}
}
