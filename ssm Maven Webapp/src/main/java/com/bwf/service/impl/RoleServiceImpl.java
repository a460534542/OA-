package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.RoleMapper;
import com.bwf.entity.Role;
import com.bwf.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.getAllRoles();
	}

}
