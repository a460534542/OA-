package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Permission;

public interface PermissionMapper {

	List<Permission> getAllPermissions();

	List<Permission> getPermissionsByRoleId(Integer roleId);

	void deletePermissionsByRoleId(Integer roleId);

	void addPermissions(@Param("roleId") Integer roleId,@Param("permissionIds") Integer[] permissionIds);

}
