package com.dealshark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.OrderUser;

public interface OrderUserController {
	
	ClientMessage addOrderUser(OrderUser orderUser);
	
	
	// Here we return the hero object we were looking for
	OrderUser findOrderUser(OrderUser orderUser, HttpServletRequest request);
	
	List<OrderUser> findAllOrderUser();

}
