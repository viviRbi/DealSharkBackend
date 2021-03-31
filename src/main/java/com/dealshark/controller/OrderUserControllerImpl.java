package com.dealshark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dealshark.ajax.ClientMessage;
import com.dealshark.model.OrderUser;
import com.dealshark.model.User;
import com.dealshark.service.OrderUserService;
import static com.dealshark.util.ClientMessageUtil.*;

@Controller("orderUserController")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderUserControllerImpl implements OrderUserController {
	
	
	@Autowired
	private OrderUserService orderUserService;

	
	
	
	@PostMapping("/newOrder")
	public @ResponseBody ClientMessage addOrderUser(@RequestBody OrderUser orderUser) {
		System.out.println("here is the order user we took in " + orderUser);
		return (orderUserService.insertOrderUser(orderUser)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
		
	}
	


	
	
	
	@PostMapping("/findOrderUser")
	public @ResponseBody OrderUser findOrderUser(@RequestBody OrderUser orderUser, HttpServletRequest request) {
		
		request.getSession();
		return orderUserService.getByOrderUserId(orderUser.getOrderUserId());
	}

	
	
	
	@GetMapping("/findAllOrderUser")
	public @ResponseBody List<OrderUser> findAllOrderUser() {
		
		return orderUserService.getAllOrderUser();
	}

}
