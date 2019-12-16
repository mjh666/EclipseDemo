package com.example.service;

import java.util.List;

import com.example.entity.User;

/**
* �û�ҵ���ӿ�
*/
public interface IUserService {

	/**
	* ��ѯȫ���û�����
	* @return �û��б�
	*/
	List<User> findAll();
	/**
	* �����û�id��ѯ�û�����
	* @param id �û�id
	* @return �û�����
	*/
	User findById(Integer id);
	/**
	* �����û�����
	* @param user �û�����
	*/
	void addnew(User user);
	/**
	* �޸��û�����
	* @param user �û�����
	*/
	void updateById(User user);
	/**
	* ɾ���û�����
	* @param id �û���id
	*/
	void deleteById(Integer id);
	
}
