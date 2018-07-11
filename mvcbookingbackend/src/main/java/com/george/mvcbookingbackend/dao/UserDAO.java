package com.george.mvcbookingbackend.dao;

import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

public interface UserDAO {
	
	//add a user
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	
	//add a booking
	boolean addBooking(Booking booking);

}
