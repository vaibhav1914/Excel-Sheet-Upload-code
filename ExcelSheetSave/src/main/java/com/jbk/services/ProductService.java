package com.jbk.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jbk.model.ProductModel;

public interface ProductService {
	
	public String uploadSheet(MultipartFile myfile);
	public boolean addProduct(ProductModel productModel);

}
