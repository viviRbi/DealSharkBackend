package com.dealshark.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dealshark.model.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void save(User user) {

		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {

		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findByName(String passedThruName) {
		
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("name", passedThruName))
					.list().get(0);
		} catch(IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

}
