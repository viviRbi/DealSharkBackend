package com.dealshark.repository;

import java.util.List;

import com.dealshark.model.User;

public interface UserRepository {

	void save(User user);
	
	List<User> findAll();
	
	User findByName(String passedThruName);
}
