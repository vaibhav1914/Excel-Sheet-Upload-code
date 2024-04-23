package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.entity.ProductEntity;
import com.jbk.exceptions.ResourceNotFound;
import com.jbk.exceptions.ResourcesAlreadyExist;
import com.jbk.exceptions.SomethingWentWrong;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(ProductEntity productEntity) {
		boolean isAdded = false;
		try {
			Session session = sessionFactory.openSession();
			List<ProductEntity> dbdEntity = getProductByName(productEntity.getProductName());
			if (dbdEntity == null) {
				session.save(productEntity);
				session.beginTransaction().commit();
				isAdded = true;
			} else {
				throw new ResourcesAlreadyExist("Resources already Exist! ID : " + productEntity.getProductId());
			}
		} catch (RollbackException e) {
			// TODO: handle exception
			throw new SomethingWentWrong("something went wrong during adding product");
		}
		return isAdded;
	}

	@Override
	public List<ProductEntity> getProductByName(String productName) {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductEntity.class);
		    criteria.add(Restrictions.eq("productName", productName));
		    List<ProductEntity> list = criteria.list();
			if(!list.isEmpty()) 
			{
				return list;
			}else 
			{
				return null;
			}
		  
		} catch (RollbackException e) {
			throw new SomethingWentWrong("something went wrong during getting Product by name");
		}
	}
	
}
