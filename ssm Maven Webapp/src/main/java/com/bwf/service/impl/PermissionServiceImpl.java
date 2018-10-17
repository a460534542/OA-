package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.PermissionMapper;
import com.bwf.entity.Permission;
import com.bwf.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {
	
	@Autowired
	com.bwf.dao.PermissionMapper permissionMapper;

	@Override
	public List<Permission> getAllPermissions() {
		// TODO Auto-generated method stub
		return permissionMapper.getAllPermissions();
	}

	@Override
	public List<Permission> getPermissionsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionsByRoleId(roleId);
	}
	
	public List<Integer> getPermissionIdFormPermissionList ( List<Permission> permissions ) {
		List<Integer> list = new ArrayList<Integer>();
		for( Permission p : permissions ) {
			list.add( p.getPermissionId() );
		}
		return list;
	}

	@Transactional
	@Override
	public void updatePermissionByRoleId(Integer roleId, Integer[] permissionIds) {
		
		// 1) 删除该角色的所有权限
		permissionMapper.deletePermissionsByRoleId( roleId );
		
		// 2) 给该角色添加新的权限
		permissionMapper.addPermissions( roleId , permissionIds );
	}

}
