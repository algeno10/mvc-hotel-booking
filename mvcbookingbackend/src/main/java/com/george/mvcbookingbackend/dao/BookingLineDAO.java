package com.george.mvcbookingbackend.dao;

import java.util.List;
import com.george.mvcbookingbackend.dto.BookingLine;

public interface BookingLineDAO {
	
	// the common methods from the previously coded one
	public BookingLine get(int id);
	public boolean add(BookingLine bookingLine);
	public boolean update(BookingLine bookingLine);
	public boolean delete(BookingLine bookingLine);
	public List<BookingLine> list(int bookingId);
	
	//other business method s related to the booking lines
	public List<BookingLine>  listAvailable(int bookingId);
	public BookingLine getByBookingAndProperty(int bookingId, int propertyId);
	

}
