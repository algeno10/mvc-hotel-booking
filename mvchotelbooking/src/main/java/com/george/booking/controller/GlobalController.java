package com.george.booking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.george.booking.model.UserModel;
import com.george.mvcbookingbackend.dao.UserDAO;
import com.george.mvcbookingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel")==null) {
			
			//add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			if(user!=null) {
				
				//create a new UserModel object to pass the details
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() +" "+ user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					//set the booking only if the user is a customer
					userModel.setBooking(user.getBooking());
				}
				
				//set the userModel in the session
				session.setAttribute("userModel", "userModel");
				return userModel;
				
			}
			
		}
		
		return (UserModel) session.getAttribute("userModel");
	}

}
