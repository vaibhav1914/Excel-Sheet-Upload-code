package com.jbk.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jbk.dao.CategoryDao;
import com.jbk.entity.CategoryEntity;
import com.jbk.exceptions.ResourceNotFound;
import com.jbk.exceptions.ResourcesAlreadyExist;
import com.jbk.exceptions.SomethingWentWrong;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
  private SessionFactory sessionFactory;

	@Override
	public boolean addCategory(CategoryEntity categoryEntity) {
		boolean isAdded=false;
		try {
			Session session=sessionFactory.openSession();
			
			CategoryEntity dbEntity=session.get(CategoryEntity.class,categoryEntity.getCategoryId());
			if(dbEntity==null) 
			{
				
				session.save(categoryEntity);
				session.beginTransaction().commit();
				isAdded=true;
			}else
			{
				throw new ResourcesAlreadyExist("Resource already Exist for Id : "+categoryEntity.getCategoryId());
			}
			
		} catch (RollbackException e) {
			// TODO: handle exception
			throw new SomethingWentWrong("something went wrong during adding Category");
		}
		return isAdded;
	}

	@Override
	public CategoryEntity getCategoryById(long categoryId) {
		try {
			Session session=sessionFactory.openSession();
			CategoryEntity dbEntity=session.get(CategoryEntity.class, categoryId);
			if(dbEntity!=null) 
			{
				return dbEntity;
			}else 
			{
				throw new ResourceNotFound("Resource not found for Id : "+categoryId);
			}
			
		} catch (RollbackException e) {
			// TODO: handle exception
			throw new SomethingWentWrong("something went wrong during getting Category by Id");
		}
		
	}
}
