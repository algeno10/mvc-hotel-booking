package com.george.booking.model;

import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.User;

public class RegisterModel {
	
	private User user;
	private Address billing;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}

}
