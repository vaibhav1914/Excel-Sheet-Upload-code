package com.jbk.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.model.SupplierModel;
import com.jbk.services.SupplierService;

@Service
public class SupplierServiceimpl implements SupplierService {
	
	@Autowired
	private SupplierDao dao;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public boolean addSupplier(SupplierModel supplierModel) {
		// TODO Auto-generated method stub
	
		
		return dao.addSupplier( modelMapper.map(supplierModel,SupplierEntity.class));
	}

}
