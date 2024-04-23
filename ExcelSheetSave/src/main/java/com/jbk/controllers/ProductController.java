package com.jbk.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jbk.model.ProductModel;
import com.jbk.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/upload-sheet")
	public ResponseEntity<String> uploadSheet(@RequestParam MultipartFile myfile) 
	{
		
		return ResponseEntity.ok(service.uploadSheet(myfile));
		
	}
	
}
