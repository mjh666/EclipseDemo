package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addnew(User user) {
		//检查用户名是否存在
		User u = userMapper.selectByUsername(user.getUsername());
		if (u != null) {
		throw new RuntimeException("用户名已经存在！");
		}
		//默认值的设置
		user.setIsDelete(0); //默认0表示正常状态
		//保存到数据库中
		userMapper.insert(user);
		
	}

	@Override
	public void updateById(User user) {
		//检查要修改的数据是否存在
		User one = userMapper.selectById(user.getId());
		if (one == null) {
		throw new RuntimeException("要修改的用户数据不存在！");
		}
		//检查用户名是否存在
		User u = userMapper.selectByUsername(user.getUsername());
		if (u != null && one.getId() != u.getId()) {
		throw new RuntimeException("用户名已经存在！");
		}
		//设置可修改的属性
		one.setUsername(user.getUsername());
		one.setPassword(user.getPassword());
		one.setAge(user.getAge());
		one.setPhone(user.getPhone());
		one.setEmail(user.getEmail());
		//更新到数据库中
		userMapper.updateById(one);
		
	}

	@Override
	public void deleteById(Integer id) {
		//检查要修改的数据是否存在
		User one = userMapper.selectById(id);
		if (one == null) {
		throw new RuntimeException("要删除的用户数据不存在！");
		}
		//删除用户数据
		userMapper.deleteById(id);
		
	}

	
	
}
