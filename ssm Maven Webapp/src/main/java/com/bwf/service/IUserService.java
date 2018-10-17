package com.bwf.service;

import java.util.List;

import javax.validation.Valid;

import com.bwf.entity.User;

public interface IUserService {

	
	User login( User user );


	List<User> getAllUser();


	List<User> getAllUserByPage(Integer page, Integer pagesize);


	Integer getAllUserCount();


	void delete(Integer id);


	void delete(Integer[] id);


	void add(@Valid User user);


	User getUserById(Integer id);

	

//	User getMenusByUserId(int userId);
}
