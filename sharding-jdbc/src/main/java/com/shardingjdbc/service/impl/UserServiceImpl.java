package com.shardingjdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shardingjdbc.entity.User;
import com.shardingjdbc.mapper.UserMapper;
import com.shardingjdbc.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> queryAll() {
		return userMapper.queryAll();
	}

	@Override
	public long insert(User user) throws Exception{
		for (int i = 0; i < 10; i++) {
			User user1 = new User();
			user1.setName("tang1111" + i);
			userMapper.insert(user1);
			if(i == 5){
				System.out.println("exception -----");
				try{
					throw new Exception();
				}catch (Exception e) {
					e.printStackTrace();
					//throw new Exception();
				}
			}
		}
		//return userMapper.insert(user);
		return 0;
	}

}
