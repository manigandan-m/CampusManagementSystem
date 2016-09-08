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

public class AddressDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();   
    
	public void insertAddress(Address address) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try {
        	
        	session.save(address);        	
        	transaction.commit();
        	
        	                
        } catch (HibernateException e) { 
        	System.out.println(e);
            throw new DatabaseException("Entered address is not added. ..", e);
        } finally {
            session.close();
        }                                                                         
    }   

	
}
