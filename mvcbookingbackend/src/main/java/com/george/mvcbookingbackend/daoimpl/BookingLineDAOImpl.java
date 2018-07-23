package com.george.mvcbookingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.george.mvcbookingbackend.dao.BookingLineDAO;
import com.george.mvcbookingbackend.dto.BookingLine;

@Repository("bookingLineDAO")
@Transactional
public class BookingLineDAOImpl implements BookingLineDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BookingLine get(int id) {
		return sessionFactory.getCurrentSession().get(BookingLine.class, id);
	}

	@Override
	public boolean add(BookingLine bookingLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BookingLine bookingLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BookingLine bookingLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookingLine> list(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingLine> listAvailable(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingLine getByBookingAndProperty(int bookingId, int propertyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
