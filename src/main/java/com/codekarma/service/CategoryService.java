package com.codekarma.service;

import java.util.List;

import com.codekarma.domain.Category;

public interface CategoryService {

	List<Category> getCategories();

	Category getCategory(String name);
	
	Category getCategory(Integer id);
}
