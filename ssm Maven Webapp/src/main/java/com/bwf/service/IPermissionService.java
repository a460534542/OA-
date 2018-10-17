package com.bwf.service;

import java.util.ArrayList;
import java.util.List;

import com.bwf.entity.Permission;

public interface IPermissionService {

	List<Permission> getAllPermissions();

	List<Permission> getPermissionsByRoleId(Integer roleId);
	
	List<Integer> getPermissionIdFormPermissionList ( List<Permission> permissions ) ;

	void updatePermissionByRoleId(Integer roleId, Integer[] permissionIds);

}
