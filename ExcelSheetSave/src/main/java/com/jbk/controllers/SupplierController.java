package com.jbk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.SupplierModel;
import com.jbk.services.SupplierService;

@RestController
@RequestMapping("supplier")
public class SupplierController {
	@Autowired
private	SupplierService service;

	@PostMapping("/add-supplier")
	public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierModel supplierModel) 
	{
		service.addSupplier(supplierModel);
		return ResponseEntity.ok("Added.....");
	}
	
	
}
