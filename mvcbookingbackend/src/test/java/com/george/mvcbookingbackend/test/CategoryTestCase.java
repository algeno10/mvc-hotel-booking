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
	
 /*   @Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Boutique Hotel");
		category.setDescription("This is a description for a boutique hotel");
		category.setImageURL("CAT_4.png");
		
		assertEquals("Succesfully added a category inside the table", true, categoryDAO.add(category));
	} */
	
	
 /* @Test
	public void testGetCategory() {
		
		category = categoryDAO.get(1);
		assertEquals("Succesfully fetched a category inside the table", "Hotel", category.getName());
	} */
	
	
/*	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(1);
		
		category.setName("Hotel");
		assertEquals("Succesfully updated a category inside the table", true, categoryDAO.update(category));
	} */
	
	
/*	@Test
    public void testDeleteCategory() {
		
		category = categoryDAO.get(4);
		assertEquals("Succesfully deleted a category inside the table", true, categoryDAO.delete(category));
	} */
	
	
/*	@Test
    public void testListCategory() {
		
		assertEquals("Succesfully the list of categories from the table", 3, categoryDAO.list().size());
	} */
	
	@Test
	public void testCRUDCategory() {
		
		//add operation
        category = new Category();
		
		category.setName("Boutique Hotel");
		category.setDescription("This is a description for a boutique hotel");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Succesfully added a category inside the table", true, categoryDAO.add(category));
	
	    
		
		category = new Category();
		
		category.setName("Bed & Breakfast");
		category.setDescription("This is a description for a bed & breakfast");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Succesfully added a category inside the table", true, categoryDAO.add(category));
	
	    
		//fetching and updating the category
        category = categoryDAO.get(2);
		
		category.setName("Hotel");
		
		assertEquals("Succesfully updated a category inside the table", true, categoryDAO.update(category));
		
		
		//delete the category
		assertEquals("Succesfully deleted a category inside the table", true, categoryDAO.delete(category));
	
	    //fetching the list of categories
		assertEquals("Succesfully the list of categories from the table", 1, categoryDAO.list().size());
	}
	
	
	
	

}
