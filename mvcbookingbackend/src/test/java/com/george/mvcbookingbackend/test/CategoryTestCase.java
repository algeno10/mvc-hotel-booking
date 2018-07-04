package com.george.mvcbookingbackend.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.george.mvcbookingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");	
	}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Hotel");
		category.setDescription("This is a description for a hotel");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Succesfully added a category inside the table", true, categoryDAO.add(category));
	}

}
