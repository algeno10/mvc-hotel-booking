package com.george.mvcbookingbackend.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Property;


@Repository("propertyDAO")
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
    
	/*
	 * LIST ALL ACTIVE PROPERTIES
	 * */
	@Override
	public List<Property> listActiveProperties() {
		String selectActiveProperties = "FROM Property WHERE active = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProperties, Property.class)
				.setParameter("active", true)
				.getResultList();
	}
    
    /*
     * LIST ACTIVE PROPERTIES BY CATEGORY
     * */
	@Override
	public List<Property> listActivePropertyByCategory(int categoryId) {
		String selectActivePropertiesByCategory = "FROM Property WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActivePropertiesByCategory, Property.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Property> getLatestActiveProperty(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Property WHERE active = :active ORDER BY id", Property.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
