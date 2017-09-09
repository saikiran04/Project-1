package com.niit.laptopsbackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptopsbackend.model.Product;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	public void saveProduct(Product product) {

		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.save(product);
		t.commit();
		
	}

}
