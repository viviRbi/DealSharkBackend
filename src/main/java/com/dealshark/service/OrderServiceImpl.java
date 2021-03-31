package com.dealshark.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealshark.model.Order;
import com.dealshark.repository.OrderRepository;
import com.dealshark.repository.OrderUserRepository;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{
	
private Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderServiceImpl() {
		logger.trace("Injection using Autowired User Repository in OrderServiceImpl");
	}

	@Override
	public boolean insertOrder(Order order) {
		
		orderRepository.save(order);
		return order.getGameId() != 0;
	}

}
