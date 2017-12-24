package com.shardingjdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shardingjdbc.entity.User;
import com.shardingjdbc.mapper.UserMapper;
import com.shardingjdbc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> queryAll() {
		return userMapper.queryAll();
	}

	@Override
	public long insert(User user) {
		return userMapper.insert(user);
	}

}
