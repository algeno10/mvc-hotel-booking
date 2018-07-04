package com.george.mvcbookingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Hotel");
		category.setDescription("This is a description for a hotel");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		
        category = new Category();
		
		//second category
		category.setId(2);
		category.setName("Guest House");
		category.setDescription("This is a description for a guest house");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		
        category = new Category();
		
		//third category
		category.setId(3);
		category.setName("Lodge");
		category.setDescription("This is a description for a lodge");
		category.setImageURL("CAT_3.png");
		
		
		categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
