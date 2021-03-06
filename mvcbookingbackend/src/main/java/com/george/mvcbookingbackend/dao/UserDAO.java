package com.george.mvcbookingbackend.dao;

import java.util.List;

import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

public interface UserDAO {
	
	//add a user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	//alternative
	//Address getBookingAddress(int userId);
	//List <Address> listBookingAddress(int userId);
	
	Address getBookingAddress(User user);
	List <Address> listBookingAddress(User user);
	
	//add a booking
	boolean updateBooking(Booking booking);

}
