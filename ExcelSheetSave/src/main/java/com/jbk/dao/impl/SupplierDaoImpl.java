package com.jbk.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.exceptions.ResourcesAlreadyExist;
import com.jbk.exceptions.SomethingWentWrong;

@Repository
public class SupplierDaoImpl implements SupplierDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(SupplierEntity supplierEntity) {
		boolean isAdded=false;
		try {
			Session session = sessionFactory.openSession();
			SupplierEntity dbEntity = session.get(SupplierEntity.class, supplierEntity.getSupplierId());
			if (dbEntity==null) {
				session.save(supplierEntity);
				session.beginTransaction().commit();
				isAdded=true;
			} else {
				throw new ResourcesAlreadyExist("Resource already Exist for Id : "+supplierEntity.getSupplierId());
				
			}
		} catch (RollbackException e) {
			// TODO: handle exception
			throw new SomethingWentWrong("something went wrong during adding Category");
		}
		return isAdded;
		
	}

}
