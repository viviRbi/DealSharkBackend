package com.dealshark.service;

import java.util.List;

import com.dealshark.model.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(String userName, String userPassword);
	
	public User getByUsername(String username);
	
	public String updateSavedGame(String saved_games, int user_id);
	
	public String getSavedGame(int user_id);

}
