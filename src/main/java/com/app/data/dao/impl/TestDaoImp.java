package com.app.data.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.data.dao.TestDao;

@Repository("testDao")
public class TestDaoImp implements TestDao {

	private SessionFactory sessionFactory;

	@Autowired	
	public TestDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void getExisting() {
		
		String qry = "Select * From abc";
		
		Query query = sessionFactory.getCurrentSession().createQuery(qry);
		
		query.setParameter("status", "SUCCESS");
		try {
		Object otpStoreObj = query.uniqueResult();
		} catch (Exception e) {

		}
	}
	
	@Override
	public void saveStorage(Object storageObj) {
		sessionFactory.getCurrentSession().persist(storageObj);
	}
	
	@Override
	public void updateStatus(Object storageObj) {
		sessionFactory.getCurrentSession().update(storageObj);
	}

	
}
