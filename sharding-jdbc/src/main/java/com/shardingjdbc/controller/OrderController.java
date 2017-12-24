package com.shardingjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shardingjdbc.entity.Order;
import com.shardingjdbc.entity.OrderItem;
import com.shardingjdbc.entity.User;
import com.shardingjdbc.service.OrderItemService;
import com.shardingjdbc.service.OrderService;
import com.shardingjdbc.service.UserService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;

	@Resource
	private OrderItemService orderItemService;

	@Resource
	private UserService userService;

	@RequestMapping(value = "test")
	public void init() {
		System.out.println("---------------");

		orderService.dropTable();
		orderItemService.dropTable();

		orderService.createIfNotExistsTable();
		orderItemService.createIfNotExistsTable();
		orderService.truncateTable();
		orderItemService.truncateTable();

		List<Long> orderIds = new ArrayList<>(10);
		System.out.println("1.Insert--------------");
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setUserId(57);
			order.setStatus("INSERT_TEST");
			orderService.insert(order);
			long orderId = order.getOrderId();
			orderIds.add(orderId);

			OrderItem item = new OrderItem();
			item.setOrderId(orderId);
			item.setUserId(57);
			item.setStatus("INSERT_TEST");
			orderItemService.insert(item);
		}

		List<Order> query = orderService.query(54);
		for (Order order : query) {
			System.out.println(order.getStatus());
		}
	}

	@RequestMapping(value = "user")
	public void user() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("tang" + i);
			userService.insert(user);
		}

		List<User> query = userService.queryAll();
		for (User user : query) {
			System.out.println(user.getName());
		}
	}
}
