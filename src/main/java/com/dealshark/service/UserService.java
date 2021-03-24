package com.dealshark.service;

import java.util.List;

import com.dealshark.model.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(String name);

}
