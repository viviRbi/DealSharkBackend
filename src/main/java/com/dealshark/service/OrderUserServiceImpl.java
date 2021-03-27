package com.dealshark.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealshark.model.OrderUser;
import com.dealshark.repository.OrderUserRepository;
import com.dealshark.repository.UserRepository;

@Service("OrderUserService")
public class OrderUserServiceImpl implements OrderUserService{
	
	private Logger logger = Logger.getLogger(OrderUserServiceImpl.class);
	
	@Autowired
	private OrderUserRepository orderUserRepository;
	
	public OrderUserServiceImpl() {
		logger.trace("Injection using Autowired User Repository in OrderUserServiceImpl");
	}


	@Override
	public boolean insertOrderUser(OrderUser orderUser) {
		orderUserRepository.save(orderUser);
		return orderUser.getOrderUserId() != 0;
	}

	
	
	
	
	
	
	@Override
	public List<OrderUser> getAllOrderUser() {
		
		return orderUserRepository.findAll();
	}
	
	
	
	

	@Override
	public OrderUser getByOrderUserId(int id) {
		
		return orderUserRepository.findByUserId(id);
	}

}
