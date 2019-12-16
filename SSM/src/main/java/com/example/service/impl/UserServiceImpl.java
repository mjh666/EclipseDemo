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
		//����û����Ƿ����
		User u = userMapper.selectByUsername(user.getUsername());
		if (u != null) {
		throw new RuntimeException("�û����Ѿ����ڣ�");
		}
		//Ĭ��ֵ������
		user.setIsDelete(0); //Ĭ��0��ʾ����״̬
		//���浽���ݿ���
		userMapper.insert(user);
		
	}

	@Override
	public void updateById(User user) {
		//���Ҫ�޸ĵ������Ƿ����
		User one = userMapper.selectById(user.getId());
		if (one == null) {
		throw new RuntimeException("Ҫ�޸ĵ��û����ݲ����ڣ�");
		}
		//����û����Ƿ����
		User u = userMapper.selectByUsername(user.getUsername());
		if (u != null && one.getId() != u.getId()) {
		throw new RuntimeException("�û����Ѿ����ڣ�");
		}
		//���ÿ��޸ĵ�����
		one.setUsername(user.getUsername());
		one.setPassword(user.getPassword());
		one.setAge(user.getAge());
		one.setPhone(user.getPhone());
		one.setEmail(user.getEmail());
		//���µ����ݿ���
		userMapper.updateById(one);
		
	}

	@Override
	public void deleteById(Integer id) {
		//���Ҫ�޸ĵ������Ƿ����
		User one = userMapper.selectById(id);
		if (one == null) {
		throw new RuntimeException("Ҫɾ�����û����ݲ����ڣ�");
		}
		//ɾ���û�����
		userMapper.deleteById(id);
		
	}

	
	
}
