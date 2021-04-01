package com.dealshark.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dealshark.model.OrderUser;
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
	public User authentication(String userName, String userPassword) {
		//System.out.println("Loging in");
		User user = new User();
		User sendUser;
		boolean success = false;
		try {
			
			user = (User) sessionFactory.getCurrentSession().createQuery("FROM User U WHERE U.username = :userName AND U.password= :password")
					.setParameter("userName", userName).setParameter("password", userPassword)
	                .uniqueResult();

	            if (user != null && user.getPassword().equals(userPassword)) {
	                success = true;
	            }
		} catch(IndexOutOfBoundsException e) {
			logger.debug(e);
		}
		if (success == true) {
			// -----------------------------------------------Set session here
			// send a user with an empty password
			sendUser = new User(user.getId(), userName, userPassword, user.getFirstName(), user.getLastName(), user.getBalance(), user.getGamesArray(),user.getPurchasedArray()); 
		} else {
			sendUser = new User(0,"", "", "", "", 0);
		}
		return sendUser;
	}

	@Override
	public User findByUsername(String username) {
		
	try {
			
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username))
					.list().get(0);
			
		} catch(IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
			
			
		}
	}
	
	@Override public void update(User user) {
		System.out.println("repository");
		System.out.println("Here is the users info: " + user.getFirstName() + user.getLastName());
		Query query = sessionFactory.getCurrentSession().createQuery("update User u set u.balance =:newBalance, u.username =:newUsername, "
				+ " u.password =:newPassword, u.firstName =:newFirstName, u.lastName =:newLastName where u.id =:userId");
		query.setParameter("newBalance", user.getBalance());
		query.setParameter("newUsername", user.getUsername());
		query.setParameter("newPassword", user.getPassword());
		query.setParameter("newFirstName", user.getFirstName());
		query.setParameter("newLastName", user.getLastName());
		query.setParameter("userId", user.getId());
		
		int result = query.executeUpdate();
		if(result > 0) {
        	System.out.println("Success");
        }
        else {
        	System.out.println("Fail");
        }	
	}
	
	//----------------------------------------- Game Repository in user repository. Update later
	@Override
	public String updateSavedGame(String savedGameIds, int userId) {
System.out.println("repository");
        Query query = sessionFactory.getCurrentSession().createQuery("update User u set u.gamesArray =:savedGameIds where u.id = :userId");
        query.setParameter("savedGameIds", savedGameIds);  
        query.setParameter("userId", userId);  
        int result = query.executeUpdate();
        if(result > 0) {
        	System.out.println("Success");
        	return savedGameIds;
        }
        else {
        	System.out.println("Fail");
        	return null;}	
	}
	@Override
	public String getSavedGame(int user_id) {
		System.out.println("get saved game Repository");
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u.gamesArray FROM User u WHERE u.id = :userId");
		query.setParameter("userId", user_id);
		String savedGame = (String) query.uniqueResult();
		System.out.println("get saved game " + savedGame);
		return savedGame;
	}

	

	
}
