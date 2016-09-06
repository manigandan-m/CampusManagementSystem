package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "role")
public class Role {
	
	@Id
	@Column(name = "role_id")
    private String roleId;
	
	@Column(name = "role_name")
    private String roleName;
	
	public Role() {
	}
	
    public String getId() {
		return roleId;
	}
	
	public void setId(String roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Role(String roleName) {
		this.roleName =roleName;
	}
}

