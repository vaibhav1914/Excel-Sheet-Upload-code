package com.jbk.dao;

import java.util.List;

import com.jbk.entity.ProductEntity;

public interface ProductDao {
	
	public boolean addProduct(ProductEntity productEntity);
	public List<ProductEntity> getProductByName(String productName);
	
}
