package com.dealshark.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dealshark.model.OrderUser;
import com.dealshark.model.User;

@Repository("orderUserRepository")
@Transactional
public class OrderUserRepositoryImpl implements OrderUserRepository{
	
	private static Logger logger = Logger.getLogger(OrderUserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public OrderUserRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void save(OrderUser orderUser) {

		sessionFactory.getCurrentSession().save(orderUser);
	}
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderUser> findAll() {

		return sessionFactory.getCurrentSession().createCriteria(OrderUser.class).list();
	}

	@Override
	public OrderUser findByUserId(int id) {
try {
			
			return (OrderUser) sessionFactory.getCurrentSession().createCriteria(OrderUser.class).add(Restrictions.like("id", id))
					.list().get(0);
			
		} catch(IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
			
			
		}
	}
	

}
