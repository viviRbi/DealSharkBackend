package com.dealshark.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dealshark.model.Order;

@Repository("orderRepository")
@Transactional
public class OrderRepositoryImpl implements OrderRepository{

	private static Logger logger = Logger.getLogger(OrderRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public OrderRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
	
	
	
	
	@Override
	public void save(Order order) {

		sessionFactory.getCurrentSession().save(order);
	}

}
