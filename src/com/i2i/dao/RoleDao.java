package com.i2i.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

public class RoleDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    
    public void insertRole(Role role) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
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

    public void deleteRole(int roleId) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Role role = (Role) session.get(Role.class, roleId); 
            session.delete(role);
            transaction.commit();            
        } catch (IllegalArgumentException e) {      
        	System.out.println(e);
            throw new DatabaseException("Entered role is not deleted. Kindly try again with vaild user id", e);
        } finally {
            session.close();
        }                            
    }
    
    public List<Role> selectRoles() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<Role> roles = new ArrayList<Role>();        
         
        try {
        	System.out.println("In roledao");
        	roles = session.createQuery("FROM Role").list();
            if (roles.isEmpty()) {
            	System.out.println("List is empty");
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
