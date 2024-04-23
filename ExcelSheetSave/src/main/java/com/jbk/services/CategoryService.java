package com.jbk.services;

import com.jbk.model.CategoryModel;

public interface CategoryService {

	public boolean addCategory(CategoryModel categoryModel);
	public CategoryModel getCategoryById(long categoryId);
}
