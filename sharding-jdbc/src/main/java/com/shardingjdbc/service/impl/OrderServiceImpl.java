package com.shardingjdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shardingjdbc.entity.Order;
import com.shardingjdbc.mapper.OrderMapper;
import com.shardingjdbc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderMapper orderMapper;
	
	@Override
	public void createIfNotExistsTable() {
		orderMapper.createIfNotExistsTable();
	}

	@Override
	public void truncateTable() {
		orderMapper.truncateTable();		
	}

	@Override
	public Long insert(Order model) {
		return orderMapper.insert(model);
	}

	@Override
	public void delete(Long orderId) {
		orderMapper.delete(orderId);
	}

	@Override
	public void dropTable() {
		orderMapper.dropTable();
	}

	@Override
	public List<Order> query(int userId) {
		return orderMapper.query(userId);
	}

}
