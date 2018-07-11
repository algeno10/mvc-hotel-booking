package com.george.mvcbookingbackend.dto;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Property {
	
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Please enter the Property Address!")
	private String address;
	@NotBlank(message="Please enter the Property Name!")
	private String name;
	private String code;
	@JsonIgnore
	@NotBlank(message="Please enter the description for Property!")
	private String description;
	@Column(name = "booking_price")
	@Min(value=1, message="The price cannot be less than 1!")
	private double bookingPrice;
	private int quantity;
	@Column(name = "is_active")
	private boolean active;
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name = "client_id")
	@JsonIgnore
	private int clientId;
	private int bookings;
	private int views;
	
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//Default constructor to generate the code
	public Property(){
	     this.code = "PRO" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	//Getter and Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBookingPrice() {
		return bookingPrice;
	}
	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getBookings() {
		return bookings;
	}
	public void setBookings(int bookings) {
		this.bookings = bookings;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
    
	//toString for debugging
	@Override
	public String toString() {
		return "Property [id=" + id + ", address=" + address + ", name=" + name + ", code=" + code + ", description="
				+ description + ", bookingPrice=" + bookingPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", clientId=" + clientId + ", bookings=" + bookings + ", views="
				+ views + "]";
	}
	
	
	
	
	

}
