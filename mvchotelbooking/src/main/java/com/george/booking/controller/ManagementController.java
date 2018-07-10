package com.george.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dto.Category;
import com.george.mvcbookingbackend.dto.Property;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
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
	
	//Returning a list of categories from the CategoryDAO class
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}

}
