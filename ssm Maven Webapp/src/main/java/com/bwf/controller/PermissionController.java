package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IPermissionService;
import com.bwf.service.IRoleService;

@Controller
@RequestMapping("permission")
public class PermissionController {
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IPermissionService permissionService;

	@GetMapping("show")
	public String show( Integer roleId , ModelMap modelMap ){
		
		if( roleId == null ) {
			roleId = 2;
		}
		
		// 获取当前请求的角色所拥有的权限的编号的集合
		List<Permission> currentRolePermissions = permissionService.getPermissionsByRoleId(roleId);
		List<Integer> currentRolePermissionIds = permissionService.getPermissionIdFormPermissionList(currentRolePermissions);
 		
		// 获取所有角色的集合 , 添加到 modelMap中去
		List<Role> allRoles = roleService.getAllRoles();
		List<com.bwf.entity.Permission> allPermissions = permissionService.getAllPermissions();
		
		modelMap.addAttribute("allRoles", allRoles);
		modelMap.addAttribute("allPermissions", allPermissions);
		modelMap.addAttribute("currentRolePermissionIds", currentRolePermissionIds);
		modelMap.addAttribute("roleId", roleId);
		
		return "permission/show";
	}


	@RequestMapping("save")
	public String save( Integer roleId , 
			@RequestParam("permissionId") Integer[] permissionIds ) {
		// 更新该角色的权限
		permissionService.updatePermissionByRoleId( roleId , permissionIds );
		
		// 跳回到 权限管理页面
		return "redirect:/permission/show";
	}

}
