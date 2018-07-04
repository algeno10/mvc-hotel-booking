package com.george.mvcbookingbackend.dao;
import java.util.List;
import com.george.mvcbookingbackend.dto.Category;


public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category> list();
	Category get(int id);

}
