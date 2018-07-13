package com.george.booking.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.george.booking.model.RegisterModel;
import com.george.mvcbookingbackend.dao.UserDAO;
import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		if(user.getRole().equals("USER")) {
			Booking booking = new Booking();
			booking.setUser(user);
			user.setBooking(booking);
		}
		
		//save the user
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}


}
