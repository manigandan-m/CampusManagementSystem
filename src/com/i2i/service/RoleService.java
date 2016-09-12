package com.i2i.service;

import java.util.List;

import com.i2i.dao.RoleDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Role by invoking RoleDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class RoleService {
	RoleDao roleDao = new RoleDao();
    
	/**
     * Calls the RoleDao class method to add the period to the database by passing the Role class object
     * 
     * @param role
     *     object of class Role
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addRole(Role role) throws DatabaseException {                 
    	roleDao.insertRole(role);                     
    }
    
    /**
     * Invokes the RoleDao class method to delete role using id
     * 
     * @param id
     *     id of the role to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeRoleById(int roleId) throws DatabaseException {
    	roleDao.deleteRoleById(roleId);  
    }
    
    /**
     * Invokes the RoleDao class method to get role model object using id of the role
     * Returns the role model object
     * 
     * @param id
     *     id of the role
     * @return 
     *     Role model object    
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Role getRoleById(int id) throws DatabaseException { 
    	return roleDao.findRoleById(id); 
    }
    
    /**
     * Invokes the roleDao method to edit the role details by passing the Role class object
     * 
     * @param role
     *     object of Role class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editRole(Role role)
            throws DatabaseException {
	    roleDao.editRole(role);
    }
    
    /**
     * Invokes the RoleDao class method to get the list of all of roles
     *  
     * @return 
     *     list of roles returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Role> getRoles() throws DatabaseException {
    	for(Role role : roleDao.retrieveRoles()) {
    		System.out.println(role);
    	}
        return (roleDao.retrieveRoles());
    }
}