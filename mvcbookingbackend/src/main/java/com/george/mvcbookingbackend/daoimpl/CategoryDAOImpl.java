package com.george.mvcbookingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.george.mvcbookingbackend.dao.CategoryDAO;
import com.george.mvcbookingbackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
