package com.shardingjdbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shardingjdbc.entity.User;

@Mapper
public interface UserMapper {

	List<User> queryAll();
	
	long insert(User user);
}
