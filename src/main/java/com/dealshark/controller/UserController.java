package com.dealshark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.User;

public interface UserController {
	
	ClientMessage registerUser(User user);
	
	User findUser(User user, HttpServletRequest request);
	
	List<User> findAllUsers();

}
