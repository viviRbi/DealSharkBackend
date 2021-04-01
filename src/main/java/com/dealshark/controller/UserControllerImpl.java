package com.dealshark.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/update")
	public @ResponseBody ClientMessage updateUser(@RequestBody User user) {
		return (userService.updateUser(user)) ? USER_UPDATE_SUCCESSFUL : SOMETHING_WRONG;
	}
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
		System.out.println("this is register" + user);
		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/authenticateUser")
	public @ResponseBody User findUser(@RequestBody User user, HttpServletRequest request) {
		//System.out.println("loggin in");
		//request.getSession();
		return userService.getUser(user.getUsername(), user.getPassword());
	}

	@GetMapping("/findAllUsers")
	public @ResponseBody List<User> findAllUsers() {
		
		return userService.getAllUsers();
	}
	
	@PostMapping("/updateSavedGame")
	public @ResponseBody String updateSavedGame(@RequestBody Map<String, String> json , HttpServletRequest request) {
		request.getSession();
		String saved_games = json.get("saved_games");
		int user_id  = Integer.parseInt(json.get("user_id"));
		System.out.println("saved" + saved_games);
		System.out.println("is" + user_id);
		System.out.println(request.getSession());
		return userService.updateSavedGame(saved_games, user_id);
	}
	
	@GetMapping("/getSavedGame/{id}")
	// After save user to session, empty int user_id
	public @ResponseBody String getSavedGame(@PathVariable("id") int id){
		System.out.println(id);
		
		return userService.getSavedGame(id);
	}
	
	@PostMapping("/findUser")
	public @ResponseBody User findHero(@RequestBody User user, HttpServletRequest request) {

		request.getSession();
		return userService.getByUsername(user.getUsername());
	}
	

}
