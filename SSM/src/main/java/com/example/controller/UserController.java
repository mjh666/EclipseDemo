package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.IUserService;

public class UserController {

	@Autowired
	private IUserService userService;
	/**
	* 转发到列表页面
	* URL: /user/list.do
	*/
	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
	//调用业务层对象获取用户列表数据
	List<User> users = userService.findAll();
	//将用户列表数据绑定到ModelMap中，从而转发到/user/list.html页面显示
	modelMap.addAttribute("users", users);
	//返回视图路径
	return "user/list";
	}
	/**
	* 转发到新增页面
	* URL: /user/addnew.do
	*/
	@RequestMapping("/addnew")
	public String addnew() {
	return "user/addnew";
	}
	/**
	* 保存新增数据
	* URL: /user/save.do
	*/
	@RequestMapping("/save")
	//14. 编写视图层⻚⾯
	//（WEB-INF/templates/user/list.html）
	public String save(User user) {
	//调用业务层对象保存数据
	userService.addnew(user);
	//保存成功后重定向到列表页面
	return "redirect:/user/list.do";
	}
	/**
	* 转发到修改页面
	* URL: /user/edit.do?id=1
	*/
	@RequestMapping("/edit")
	public String edit(Integer id, ModelMap modelMap) {
	//根据id查询用户数据
	User user = userService.findById(id);
	//将用户对象绑定到ModelMap，转发到页面显示
	modelMap.addAttribute("user", user);
	//返回视图路径
	return "user/edit";
	}
	/**
	* 更新修改数据
	* URL: /user/updateById.do
	*/
	@RequestMapping("/update")
	public String update(User user) {
	//调用业务层对象更新用户数据
	userService.updateById(user);
	//更新成功后重定向到列表页面
	return "redirect:/user/list.do";
	}
	/**
	* 删除数据
	* URL: /user/deleteById.do?id=1
	*/
	@RequestMapping("/delete")
	public String delete(Integer id) {
	//调用业务层对象删除用户数据
	userService.deleteById(id);
	//删除成功后重定向到列表页面
	return "redirect:/user/list.do";
	
	}
}
