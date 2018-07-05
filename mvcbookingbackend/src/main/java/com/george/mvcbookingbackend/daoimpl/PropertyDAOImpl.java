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
	
    /*
     * INSERT
     * */
	@Override
	public boolean add(Property property) {
		try {
			sessionFactory.getCurrentSession()
			.persist(property);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
    
	/*
	 * UPDATE 
	 * */
	@Override
	public boolean update(Property property) {
		try {
			sessionFactory.getCurrentSession()
			.update(property);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Property property) {
		try {
			property.setActive(false);
			//call the update method
			return this.update(property);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
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
