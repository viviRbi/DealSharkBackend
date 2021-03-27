package com.dealshark.service;

import java.util.List;

import com.dealshark.model.OrderUser;
import com.dealshark.model.User;

public interface OrderUserService {
	
public boolean insertOrderUser(OrderUser orderUser);
	
	public List<OrderUser> getAllOrderUser();
	
	
	public OrderUser getByOrderUserId(int id);

}
