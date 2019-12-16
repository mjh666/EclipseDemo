package com.example.mapper;

import java.util.List;

import com.example.entity.User;

public interface UserMapper {

	List<User> selectAll();
	User selectByUsername(String username);
	User selectById(Integer id);
	int insert(User user);
	int updateById(User user);
	int deleteById(Integer id);
	
	//���ػ����������ͣ�
}
