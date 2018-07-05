package com.george.mvcbookingbackend.dao;
import java.util.List;

import com.george.mvcbookingbackend.dto.Property;

public interface PropertyDAO {
	
	Property get(int propertyId);
	List<Property> list();
	boolean add(Property property);
	boolean update(Property property);
	boolean delete(Property property);
	
	//business methods
	List<Property> listActiveProperties();
	List<Property> listActivePropertyByCategory(int categoryId);
	List<Property> getLatestActiveProperty(int count);

}
