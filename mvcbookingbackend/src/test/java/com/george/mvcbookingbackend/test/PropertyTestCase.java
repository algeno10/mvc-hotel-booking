package com.george.mvcbookingbackend.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.george.mvcbookingbackend.dao.PropertyDAO;
import com.george.mvcbookingbackend.dto.Property;

public class PropertyTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static PropertyDAO propertyDAO;
	
	private Property property;
	
    @BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.george.mvcbookingbackend");
		context.refresh();
		propertyDAO = (PropertyDAO)context.getBean("propertyDAO");
	}
    
    
/*    @Test
    public void testCRUDProperty() {
    	
    	//create operation
    	property = new Property();
    	
    	property.setAddress("20 Rose Marry, Street");
    	property.setName("George Luxury Hotel");
    	property.setType("hotel");
    	property.setDescription("This is a hotel");
    	property.setBookingPrice(1300);
    	property.setActive(true);
    	property.setCategoryId(1);
    	property.setClientId(4);
    	
    	assertEquals("Something went wrong while inserting an new property",
    			true, propertyDAO.add(property));
    	
    	//reading and updating the category
    	property = propertyDAO.get(3);
    	property.setName("Cool Hotel");
    	assertEquals("Something went wrong while updating the existing record",
    			true, propertyDAO.update(property));
    	
    	assertEquals("Something went wrong while deleting the existing record",
    			true, propertyDAO.delete(property));
    	
    	//list
    	assertEquals("Something went wrong while updating the existing record",
    			4, propertyDAO.list().size());
    	
    } */
    
    @Test
    public void testListActiveProperties() {
    	assertEquals("Something went wrong while updating the existing record",
    			3, propertyDAO.listActiveProperties().size());
    }
    
    @Test
    public void testListActivePropertiesByCategory() {
    	assertEquals("Something went wrong while updating the existing record",
    			1, propertyDAO.listActivePropertyByCategory(2).size());
    	assertEquals("Something went wrong while updating the existing record",
    			1, propertyDAO.listActivePropertyByCategory(1).size());
    }

    @Test
    public void testGetLatestActiveProperty() {
    	assertEquals("Something went wrong while updating the existing record",
    			3, propertyDAO.getLatestActiveProperty(3).size());
    }
}
