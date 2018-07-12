package com.george.mvcbookingbackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.george.mvcbookingbackend.dao.UserDAO;
import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Booking booking = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.george.mvcbookingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
/*	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Henry");
		user.setLastName("Frick");
		user.setEmail("henryf@gmail.com");
		user.setContactNumber("0924781268");
		user.setRole("USER");
		user.setPassword("98765");
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("12 Republic Road");
		address.setAddressLineTwo("240 Surrey Avenue");
		address.setCity("Sandton");
		address.setState("Gauteng");
		address.setCountry("South Africa");
		address.setPostalCode("8679");
		address.setBilling(true);
		
		//link the user with the address using the user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a booking for the user
			booking = new Booking();
			booking.setUser(user);
			
			//add the booking
			assertEquals("Failed to add booking!", true, userDAO.addBooking(booking));
			
			address = new Address();
			address.setAddressLineOne("12 Republic Road");
			address.setAddressLineTwo("240 Surrey Avenue");
			address.setCity("Sandton");
			address.setState("Gauteng");
			address.setCountry("South Africa");
			address.setPostalCode("8679");
			//set booking to be true
			address.setBooked(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the booking
			assertEquals("Failed to add booking!", true, userDAO.addAddress(address));
		}	
	} */
	
	
/*	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Henry");
		user.setLastName("Frick");
		user.setEmail("henryf@gmail.com");
		user.setContactNumber("0924781268");
		user.setRole("USER");
		user.setPassword("98765");
		
		if(user.getRole().equals("USER")) {
			
			//create a booking for the user
			booking = new Booking();
			
			booking.setUser(user);
			
			//attach booking with the user
			user.setBooking(booking);

		}	
		//add the user
	    assertEquals("Failed to add user!", true, userDAO.addUser(user));
	} */

/*	@Test
	public void testUpdateBooking() {
		
		//fetch the user by its email
		user = userDAO.getByEmail("henryf@gmail.com");
		
		//get the booking of the user
		booking = user.getBooking();
		
		booking.setGrandTotal(2222);
		
		booking.setBookingLines(2);
		
		assertEquals("Failed to update booking!", true, userDAO.updateBooking(booking));
	} */
	
/*	@Test
	public void testAddAddress() {
		
		//we need to add a user
		user = new User();
		user.setFirstName("Henry");
		user.setLastName("Frick");
		user.setEmail("henryf@gmail.com");
		user.setContactNumber("0924781268");
		user.setRole("USER");
		user.setPassword("98765");
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		
		//adding an address
		address = new Address();
		address.setAddressLineOne("12 Republic Road");
		address.setAddressLineTwo("240 Surrey Avenue");
		address.setCity("Sandton");
		address.setState("Gauteng");
		address.setCountry("South Africa");
		address.setPostalCode("8679");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		//adding the booking address
		address = new Address();
		address.setAddressLineOne("12 Republic Road");
		address.setAddressLineTwo("240 Surrey Avenue");
		address.setCity("Sandton");
		address.setState("Gauteng");
		address.setCountry("South Africa");
		address.setPostalCode("8679");
		//set booking to be true
		address.setBooked(true);
		
		//attach the user to the address
		address.setUser(user);		
				
		assertEquals("Failed to add booking address!", true, userDAO.addAddress(address));
	} */
	
/*	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("henryf@gmail.com");
		
		//adding the booking address
		address = new Address();
		address.setAddressLineOne("13 Republic Road");
		address.setAddressLineTwo("241 Surrey Avenue");
		address.setCity("Nelspruit");
		address.setState("Mpumalanga");
		address.setCountry("South Africa");
		address.setPostalCode("8679");
		//set booking to be true
		address.setBooked(true);
				
		//attach the user to the address
		address.setUser(user);		
						
		assertEquals("Failed to add booking address!", true, userDAO.addAddress(address));
		
	} */
	
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("	henryf@gmail.com");
		
		assertEquals("Failed to fetch the list of address and the size does not match!", 2, 
				userDAO.listBookingAddress(user).size());
		
		assertEquals("Failed to fetch the booking of address and the size does not match!", "Sandton", 
				userDAO.getBookingAddress(user).getCity());
		
		
	}
	
	
}
