package com.dealshark.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dealshark.model.User;
import com.dealshark.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		logger.trace("Injection using Autowired User Repository in UserServiceImpl");
	}

	@Override
	public boolean registerUser(User user) {
		userRepository.save(user);
		
		return user.getId() != 0;
 	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String name) {
		
		return userRepository.findByName(name);
	}
	
	

}
