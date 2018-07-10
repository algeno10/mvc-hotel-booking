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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			}
		}
		
		return mv;
	}
	
	//handling property submission
	@RequestMapping(value="/property", method=RequestMethod.POST)
	public String handlePropertySubmission(@Valid @ModelAttribute("property") Property mProperty, BindingResult results, Model model,
			HttpServletRequest request) {
		
		new PropertyValidator().validate(mProperty, results);
		
		
		//check if there are any errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProperties", true);
			model.addAttribute("title", "Manage Properties");
			model.addAttribute("message", "Validation failed for Property Submission!");
			
			return "page";
		}
		
		logger.info(mProperty.toString());
		
		//create a new property record
		propertyDAO.add(mProperty);
		
		if(!mProperty.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProperty.getFile(), mProperty.getCode());
		}
		
		return "redirect:/manage/property?operation=property";
	}
	
	
	//Returning a list of categories from the CategoryDAO class
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}

}
