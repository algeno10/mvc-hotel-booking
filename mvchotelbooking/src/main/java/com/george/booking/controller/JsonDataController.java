package com.george.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Property;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private PropertyDAO propertyDAO;
	
	@RequestMapping("/all/property")
	@ResponseBody
	public List<Property> getAllProperties(){
		return propertyDAO.listActiveProperties();
	}
	
	@RequestMapping("/admin/all/property")
	@ResponseBody
	public List<Property> getAllPropertiesForAdmin(){
		return propertyDAO.list();
	}
	
	@RequestMapping("/category/{id}/property")
	@ResponseBody
	public List<Property> getPropertiesByCategory(@PathVariable int id){
		return propertyDAO.listActivePropertyByCategory(id);
	}

}
