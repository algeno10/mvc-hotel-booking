package com.george.mvcbookingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Property;

@Transactional
public class PropertyDAOImpl implements PropertyDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	@Override
	public Property get(int propertyId) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Property.class, Integer.valueOf(propertyId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
    
	
	/*
	 * LIST
	 * */
	@Override
	public List<Property> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM PRoperty", Property.class)
				.getResultList();
	}
	

	@Override
	public boolean add(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Property> listActiveProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> listActivePropertyByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> getLatestActiveProperty(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
