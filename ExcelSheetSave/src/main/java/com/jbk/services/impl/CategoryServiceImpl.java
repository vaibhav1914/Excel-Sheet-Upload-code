package com.jbk.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.model.CategoryModel;
import com.jbk.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean addCategory(CategoryModel categoryModel) {

		return dao.addCategory(modelMapper.map(categoryModel, CategoryEntity.class));
	}

	@Override
	public CategoryModel getCategoryById(long categoryId) {

		return modelMapper.map(dao.getCategoryById(categoryId), CategoryModel.class);

	}

}
