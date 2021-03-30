package com.dealshark.repository;

import java.util.List;

import com.dealshark.model.User;

public interface UserRepository {

	void save(User user);
	
	List<User> findAll();
	
	User authentication(String userName, String userPassword);
	
	User findByUsername(String username);
	
	String updateSavedGame(String savedGameIds, int userId);
	String getSavedGame(int user_id);
}
