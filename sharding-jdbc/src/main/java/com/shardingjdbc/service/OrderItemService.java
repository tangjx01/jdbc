package com.shardingjdbc.service;

import java.util.List;

import com.shardingjdbc.entity.OrderItem;

public interface OrderItemService {
	
	void createIfNotExistsTable();

	void truncateTable();

	Long insert(OrderItem model);

	void delete(Long orderItemId);

	List<OrderItem> selectAll();

	void dropTable();
}
