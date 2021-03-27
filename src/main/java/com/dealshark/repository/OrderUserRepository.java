package com.dealshark.repository;

import java.util.List;

import com.dealshark.model.OrderUser;
import com.dealshark.model.User;

public interface OrderUserRepository {

	
	void save(OrderUser orderUser);
	
	List<OrderUser> findAll();
	
	
	OrderUser findByUserId(int id);
}
