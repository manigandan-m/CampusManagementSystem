package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for Role
 * Role is the physical entity which depicts a position that is assigned to each person
 * Setter and Getter methods for the class variables
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-10
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

