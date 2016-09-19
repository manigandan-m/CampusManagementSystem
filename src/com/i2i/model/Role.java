package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for Role
 * Setter and Getter methods for the class variables
 * 
 * @author Manigandan
 * 
 * @created 2015-09-10
 */

@Entity
@Table(name= "role")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name = "role_id")
    private int roleId;
	
	@Column(name = "role_name")
    private String roleName;
	
	public Role() {
	}
	
    public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
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

