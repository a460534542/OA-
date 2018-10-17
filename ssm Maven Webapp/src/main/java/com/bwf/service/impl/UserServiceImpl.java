package com.bwf.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.controller.UserController;
import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

import freemarker.template.utility.StringUtil;


@Service
public class UserServiceImpl implements IUserService {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserMapper userMapper;

	// 在 service 中 ，单个方法中 执行多条 sql 语句， 我们通过作为一个 事务 来进行处理
	// 在 方法上 添加注解 @Transactional 
	@Transactional
	@Override
	public User login(User user) {		
		// 获取 user 的基本信息
		User u = userMapper.getUserByUsernameAndPassword( user );
			
		if( u != null ) {
			u = userMapper.getMenusAndOperatesByUserId(u.getUserId());
			logger.info(u.getPassword()+"");
		}
		return u;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getAllUser();
	}

	@Override
	public List<User> getAllUserByPage(Integer page, Integer pagesize) {
		// TODO Auto-generated method stub
		return userMapper.getAllUserBypage((page-1)*pagesize,pagesize);
	}

	@Override
	public Integer getAllUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserCount();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userMapper.delete(id);	
	}

	@Override
	public void delete(Integer[] id) {
		for(Integer i:id){
			userMapper.delete(i);
		}
	}

	@Override
	public void add(@Valid User user) {
		user.setPassword(StringUtils.md5(user.getPassword()));
		userMapper.add(user);
	}

	@Override
	public User getUserById(Integer id) {
		userMapper.getUserById(id);
		return null;
	}


//	@Override
//	public User getMenusByUserId(int userId) {
//		// TODO Auto-generated method stub
//		return userMapper.getMenusByUserId(userId);
//	}

}
