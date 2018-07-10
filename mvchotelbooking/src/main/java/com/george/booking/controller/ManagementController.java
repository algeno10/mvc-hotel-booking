package com.george.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.george.mvcbookingbackend.dto.Property;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@RequestMapping(value="/property", method=RequestMethod.GET)
	public ModelAndView showManageProperty() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProperties", true);
		mv.addObject("title", "Manage Properties");
		Property nProperty = new Property();
		
		//set few of the fields
		nProperty.setClientId(1);
		nProperty.setActive(true);
		
		mv.addObject("property", nProperty);
		
		return mv;
	}

}
