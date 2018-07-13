package com.george.booking.handler;

import org.springframework.stereotype.Component;

import com.george.booking.model.RegisterModel;
import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.User;

@Component
public class RegisterHandler {
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}


}
