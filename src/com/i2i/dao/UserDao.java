package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.User;
import com.i2i.model.Address;

import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;


public class UserDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    
    public void insertUser(User user) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try { 
        	session.save(user);            
            transaction.commit();        
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered user is not added. User ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    public void insertAddress(Address address) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try { 
        	session.save(address);            
            transaction.commit();        
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered address is not added. ..", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    
    public User findUser(String username) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        User user = null; 
        
        try {                           
            user = (User) session.get(User.class, username);            
            if (user == null) {
            	
                throw new DatabaseException("Invalid username");
            }                     
            return user;
        } catch (HibernateException e) { 
        	System.out.println(e);
            throw new DatabaseException("Entered user is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    }

   
    public void deleteUser(String username) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = (User) session.get(User.class, username); 
            session.delete(user);
            transaction.commit();            
        } catch (IllegalArgumentException e) {      
        	System.out.println(e);
            throw new DatabaseException("Entered user is not deleted. Kindly try again with vaild user id", e);
        } finally {
            session.close();
        }                            
    }   
    
    
    public List<User> selectUsers() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<User> users = new ArrayList<User>();        
         
        try {
            users = session.createQuery("FROM User").list();
            if (users.isEmpty()) {
                throw new DatabaseException("The user list is empty");
            }            
            return users;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The users are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }   
    
         
}
     

