package com.shardingjdbc.service;

import java.util.List;

import com.shardingjdbc.entity.Order;

public interface OrderService {
	
	void createIfNotExistsTable();

	void truncateTable();

	Long insert(Order model);

	List<Order> query(int userId);
	
	void delete(Long orderId);

	void dropTable();
}
