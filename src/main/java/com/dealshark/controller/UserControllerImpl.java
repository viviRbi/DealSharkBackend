package com.dealshark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.dealshark.util.ClientMessageUtil.*;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.User;
import com.dealshark.service.UserService;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {

		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/findUser")
	public @ResponseBody User findUser(@RequestBody User user, HttpServletRequest request) {
		
		request.getSession();
		return userService.getUser(user.getFirstName());
	}

	@GetMapping("/findAllUsers")
	public @ResponseBody List<User> findAllUsers() {
		
		return userService.getAllUsers();
	}

}
