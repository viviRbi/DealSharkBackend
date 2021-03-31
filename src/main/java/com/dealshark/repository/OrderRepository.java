package com.dealshark.repository;

import com.dealshark.model.Order;
import com.dealshark.model.OrderUser;

public interface OrderRepository {
	
	void save(Order order);

}
