package com.dealshark.controller;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.Order;
import com.dealshark.model.OrderUser;

public interface OrderController {

	ClientMessage addOrder(Order order);
}
