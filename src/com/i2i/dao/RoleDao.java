package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Role
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2016-09-05
 */

public class RoleDao {
    HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    /**
     * Saves the role to the database by passing it
     * 
     * @param role
     *     role is the position that is saved in the database
     * @throws DatabaseException
     *     if there is an error in getting the role details like HibernateException
     *     
     */
    public void insertRole(Role role) throws DatabaseException {
    	Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try { 
            session.save(role);            
            transaction.commit();        
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered role is not added.", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    /**
     * Deletes the role model object by passing roleId 
     * 
     * @param roleId
     *     id of the role to delete
     * @throws DatabaseException
     *     if there is an error in deleting the role details like HibernateException
     */
    public void deleteRoleById(int roleId) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Role role = (Role) session.get(Role.class, roleId); 
            session.delete(role);
            transaction.commit();            
        } catch (IllegalArgumentException e) {      
            throw new DatabaseException("Entered role is not deleted. Kindly try again with vaild user id", e);
        } finally {
            session.close();
        }                            
    }
    
    /**
     * Edits the role details by accessing the database, passing the Role class object.
     * 
     * @param role
     *     role whose details have to be edited
     * @throws DataBaseException
     *     if there is an error in getting the role details like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editRole(Role role) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(role);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e);  
        } finally {
            session.close(); 
        }
    }
    
    /**
     * Retrieves the role by passing id of the role
     * 
     * @param id
     *     id of the role whose record has to be viewed
     * @return role
     *    role is the position of the user
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public Role findRoleById(int id) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Role role = (Role)session.get(Role.class, id); 
            transaction.commit();
            return role;
        } catch (HibernateException e) {
            throw new DatabaseException("Check role ID, please enter different id", e);  
        } finally {
            session.close();             
        } 
    }
    
    /**
     * Retrieves  the list of roles from the database
     * 
     * @return roles
     *     List of roles
     * @throws DatabaseException
     *     if there is an error in getting the list of roles like HibernateException
     */
    public List<Role> retrieveRoles() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        try {
            List<Role> roles = session.createQuery("FROM Role").list();
            if (roles.isEmpty()) {
                throw new DatabaseException("The role list is empty");
            }            
            return roles;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The roles are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }
}
