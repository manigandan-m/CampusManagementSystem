package com.i2i.service;

import java.util.List;

import com.i2i.dao.RoleDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

public class RoleService {
	RoleDao roleDao = new RoleDao();
    
    public void addRole(Role role) throws DatabaseException {                 
    	roleDao.insertRole(role);                     
    }
    
    public void removeRole(int roleId) throws DatabaseException {
    	roleDao.deleteRole(roleId);  
    }
    
    public List<Role> getRoles() throws DatabaseException {
    	System.out.println("IN RoleService for getting list");
    	for(Role role : roleDao.selectRoles()) {
    		System.out.println(role);
    	}
        return (roleDao.selectRoles());
    }
}

