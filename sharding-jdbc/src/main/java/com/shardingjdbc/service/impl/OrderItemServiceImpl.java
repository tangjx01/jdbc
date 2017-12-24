package com.shardingjdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shardingjdbc.entity.OrderItem;
import com.shardingjdbc.mapper.OrderItemMapper;
import com.shardingjdbc.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Resource
	private  OrderItemMapper  orderItemMapper;
	
	@Override
	public void createIfNotExistsTable() {
		orderItemMapper.createIfNotExistsTable();		
	}

	@Override
	public void truncateTable() {
		orderItemMapper.truncateTable();		
	}

	@Override
	public Long insert(OrderItem model) {
		return orderItemMapper.insert(model);
	}

	@Override
	public void delete(Long orderItemId) {
		orderItemMapper.delete(orderItemId);
	}

	@Override
	public List<OrderItem> selectAll() {
		return orderItemMapper.selectAll();
	}

	@Override
	public void dropTable() {
		orderItemMapper.dropTable();		
	}

}
