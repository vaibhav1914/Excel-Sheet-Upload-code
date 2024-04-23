package com.jbk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.CategoryModel;
import com.jbk.services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@PostMapping("/add-category")
	public ResponseEntity<String> addCategory(@RequestBody @Valid CategoryModel categoryModel) 
	{
		service.addCategory(categoryModel);
		return ResponseEntity.ok("Added....");
	}
	
	@GetMapping("/get-category-by-Id")
	public ResponseEntity<CategoryModel> getCategoryById(@RequestParam long categoryId) 
	{
		
		return ResponseEntity.ok(service.getCategoryById(categoryId));
	}
}
