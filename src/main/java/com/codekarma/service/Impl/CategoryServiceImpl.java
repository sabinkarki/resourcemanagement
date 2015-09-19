package com.codekarma.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codekarma.domain.Category;
import com.codekarma.repository.CategoryRepository;
import com.codekarma.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
 
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getCategories() {
		List<Category> lst = new ArrayList<Category>();
		for(Category c: categoryRepository.findAll()){
			lst.add(c);
		}
		return lst;
	}

	public Category getCategory(String name) {
		return categoryRepository.getCategoryByName(name);
	}

	public Category getCategory(Integer id) {
		return categoryRepository.findOne(id);
	}

}
