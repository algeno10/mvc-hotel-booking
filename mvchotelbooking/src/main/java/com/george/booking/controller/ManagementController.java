package com.george.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.george.booking.util.FileUploadUtility;
import com.george.booking.validator.PropertyValidator;
import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Category;
import com.george.mvcbookingbackend.dto.Property;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PropertyDAO propertyDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/property", method=RequestMethod.GET)
	public ModelAndView showManageProperty(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProperties", true);
		mv.addObject("title", "Manage Properties");
		Property nProperty = new Property();
		
		//set few of the fields
		nProperty.setClientId(1);
		nProperty.setActive(true);
		
		mv.addObject("property", nProperty);
		
		if(operation!=null) {
			
			if(operation.equals("property")) {
				mv.addObject("message", "Property Submitted Successfully!");
			} else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/property", method=RequestMethod.GET)
	public ModelAndView showEditProperty(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProperties", true);
		mv.addObject("title", "Manage Properties");
		
		//fetch property from database
		Property nProperty = propertyDAO.get(id);
		//set the property fetched from database
		mv.addObject("property", nProperty);
		
		return mv;
	}
	
	
	//handling property submission
	@RequestMapping(value="/property", method=RequestMethod.POST)
	public String handlePropertySubmission(@Valid @ModelAttribute("property") Property mProperty, BindingResult results, Model model,
			HttpServletRequest request) {
		
		//handle image validation for new property
		if(mProperty.getId() == 0) {
			new PropertyValidator().validate(mProperty, results);
		} else {
			if(!mProperty.getFile().getOriginalFilename().equals("")) {
				new PropertyValidator().validate(mProperty, results);
			}
		}
		
		//check if there are any errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProperties", true);
			model.addAttribute("title", "Manage Properties");
			model.addAttribute("message", "Validation failed for Property Submission!");
			
			return "page";
		}
		
		logger.info(mProperty.toString());
		
		//create a new property record
		if(mProperty.getId() == 0) {
			//create a new property record if id is 0
			propertyDAO.add(mProperty);
		} else {
			//update the property if id is not 0
			propertyDAO.update(mProperty);
		}
		
		
		if(!mProperty.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProperty.getFile(), mProperty.getCode());
		}
		
		return "redirect:/manage/property?operation=property";
	}
	
	@RequestMapping(value ="/property/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handlePropertyActivation(@PathVariable int id) {
		
		//going to fectch from the database
		Property property = propertyDAO.get(id);
		
		boolean isActive = property.isActive();
		//activating and deactivating based on the value of active field
		property.setActive(!property.isActive());
		//updating the property
		propertyDAO.update(property);
		
		return (isActive)? 
				"You have successfully deactivated the property with id" +property.getId() 
				: "You have successfully activated the property with id" +property.getId();
	}
	
	//to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		//add the new category
		categoryDAO.add(category);
		return "redirect:/manage/property?operation=category";
	}
	
	
	//Returning a list of categories from the CategoryDAO class
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}

}
