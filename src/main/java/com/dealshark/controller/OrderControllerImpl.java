package com.dealshark.controller;

import static com.dealshark.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.dealshark.util.ClientMessageUtil.SOMETHING_WRONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.Order;
import com.dealshark.service.OrderService;
import com.dealshark.service.OrderUserService;

@Controller("orderController")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderControllerImpl implements OrderController{

	
	@Autowired
	private OrderService orderService;
	
	
	
	
	@PostMapping("/newOwnedGames")
	public @ResponseBody ClientMessage addOrder(@RequestBody Order order) {

		System.out.println("This is the new owned games we are sent" + order);
		return (orderService.insertOrder(order)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	
	}

}
