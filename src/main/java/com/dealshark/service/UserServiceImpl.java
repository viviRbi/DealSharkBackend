package com.dealshark.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealshark.model.User;
import com.dealshark.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		logger.trace("Injection using Autowired User Repository in UserServiceImpl");
	}

	@Override
	public boolean registerUser(User user) {
		String hashedPass = this.hashPassword(user.getPassword());
		user.setPassword(hashedPass);
		//System.out.println(hashedPass);
		userRepository.save(user);
		
		return user.getId() != 0;
 	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userName, String userPassword) {
		String hashedPass = this.hashPassword(userPassword);
		//System.out.println(hashedPass);
		//System.out.println(userRepository.authentication(userName, userPassword).toString());
		return userRepository.authentication(userName, hashedPass);
	}
	
	public String hashPassword(String password) {
		// Hash password to MD5 byte
	     MessageDigest md = null;
	     
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_16BE));
		
		// Convert hashed password to string
		 BigInteger bi = new BigInteger(1, hashedPassword );
		 String hashed = bi.toString(16);
		 
		 return hashed;
	}
	

}
