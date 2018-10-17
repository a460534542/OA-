package com.bwf.entity;

public class Role {
	
	private Integer roleId;
	
	private String roleName;
	
	private Department department;
	
	

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", department=" + department + "]";
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
