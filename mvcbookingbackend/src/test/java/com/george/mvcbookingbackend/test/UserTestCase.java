package com.george.mvcbookingbackend.test;

import org.junit.BeforeClass;
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

}
