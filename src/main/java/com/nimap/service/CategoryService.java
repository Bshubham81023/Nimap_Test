package com.nimap.service;

import org.springframework.data.domain.Page;

import com.nimap.entity.Category;

public interface CategoryService {

	public Page<Category> getCategorys(int page, int size);
	
	public Category addCategory(Category category);

	public Category getCategoryById(int id);
	
	public Category updateCategoryById(int id, Category catgory);
	
	public String deleteCategoryByid(int id);
}
