package com.george.mvcbookingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.george.mvcbookingbackend.dao.UserDAO;
import com.george.mvcbookingbackend.dto.Address;
import com.george.mvcbookingbackend.dto.Booking;
import com.george.mvcbookingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
	

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBooking(Booking booking) {
		try {
			sessionFactory.getCurrentSession().update(booking);
			return true;
		} catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
