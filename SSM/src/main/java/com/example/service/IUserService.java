package com.example.service;

import java.util.List;

import com.example.entity.User;

/**
* 用户业务层接口
*/
public interface IUserService {

	/**
	* 查询全部用户数据
	* @return 用户列表
	*/
	List<User> findAll();
	/**
	* 根据用户id查询用户数据
	* @param id 用户id
	* @return 用户对象
	*/
	User findById(Integer id);
	/**
	* 新增用户数据
	* @param user 用户对象
	*/
	void addnew(User user);
	/**
	* 修改用户数据
	* @param user 用户对象
	*/
	void updateById(User user);
	/**
	* 删除用户数据
	* @param id 用户的id
	*/
	void deleteById(Integer id);
	
}
