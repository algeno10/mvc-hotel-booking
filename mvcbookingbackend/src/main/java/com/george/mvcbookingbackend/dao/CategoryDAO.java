package com.george.mvcbookingbackend.dao;
import java.util.List;
import com.george.mvcbookingbackend.dto.Category;


public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);

}
