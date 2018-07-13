package com.george.mvcbookingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * private fields for address
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*---------------*/
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*----------------*/
	
	
	@Column(name= "grand_total")
	private double grandTotal;
	@Column(name= "booking_lines")
	private int bookingLines;
	
	/*
	 * setter and getters for the fields
	 * */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getBookingLines() {
		return bookingLines;
	}
	public void setBookingLines(int bookingLines) {
		this.bookingLines = bookingLines;
	}

	
	

}
