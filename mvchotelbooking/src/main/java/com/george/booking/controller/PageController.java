package com.george.booking.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.george.booking.exception.PropertyNotFoundException;
import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Category;
import com.george.mvcbookingbackend.dto.Property;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PropertyDAO propertyDAO;
	
	//Method for the home page
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	
	//Method for the about us page
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	
	//Method for the contact page
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the property and based on category
	 * */
	@RequestMapping(value = "/show/all/property")
	public ModelAndView showAllProperty() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Property");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProperty", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/property")
	public ModelAndView showCategoryProperty(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProperty", true);
		return mv;
	}
	
	
	/*
	 * Viewing a single property
	 * */
	@RequestMapping(value ="/show/{id}/property")
	public ModelAndView showSingleProperty(@PathVariable int id) throws PropertyNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		
		Property property = propertyDAO.get(id);
		
		if(property == null) throw new PropertyNotFoundException();
		
		//update the view count
		property.setViews(property.getViews() + 1);
		propertyDAO.update(property);
		//-----------------------------
		
		
		mv.addObject("title", property.getName());
		mv.addObject("property", property);
		
		mv.addObject("userClickShowProperty", true);
		
		return mv;
	}
	
	
	/*having similar mapping in our flow id*/
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Register");
		return mv;
	}
	
	


}
