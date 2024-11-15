package com.nimap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entity.Category;
import com.nimap.repository.CategoryRepository;
import com.nimap.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository crepo;

	@Override
	public Page<Category> getCategorys(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return crepo.findAll(pageable);
	}

	@Override
	public Category addCategory(Category category) {
		return crepo.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		return crepo.findById(id).orElse(null);
	}

	@Override
	public Category updateCategoryById(int id, Category catgory) {
		@SuppressWarnings("deprecation")
		Category categorys = crepo.getById(id);
		categorys.setC_name(catgory.getC_name());
		return crepo.save(categorys);
	}

	@Override
	public String deleteCategoryByid(int id) {
		crepo.deleteById(id);
		return "category deleted";

	}

}
