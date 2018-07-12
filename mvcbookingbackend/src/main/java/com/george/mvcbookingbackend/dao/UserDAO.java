package com.george.mvcbookingbackend.dao;

import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

public interface UserDAO {
	
	//add a user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	//add a booking
	boolean updateBooking(Booking booking);

}
