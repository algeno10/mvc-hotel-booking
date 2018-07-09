package com.george.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@RequestMapping(value="/property", method=RequestMethod.GET)
	public ModelAndView showManageProperty() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProperties", true);
		mv.addObject("title", "Manage Properties");
		
		return mv;
	}

}
