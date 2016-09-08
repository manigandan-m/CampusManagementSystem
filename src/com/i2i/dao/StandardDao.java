package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.Teacher;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;


public class StandardDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();    

    
    public void insertStandard(Standard standard) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try {     	
            session.save(standard);           
            transaction.commit();
            
        } catch (HibernateException e) {
        	e.printStackTrace();
        	System.out.println(e);
            throw new DatabaseException("Entered user is not added. Standard ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }   
    
    public void deleteStandard(int id) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
        	Standard standard = (Standard) session.get(Standard.class, id); 
            session.delete(standard);
            transaction.commit();            
        } catch (IllegalArgumentException e) {                       
            throw new DatabaseException("Entered standard is not deleted. Kindly try again with vaild student id", e);
        } finally {
            session.close();
        }                            
    }    
    
    public Standard findStandard(int id) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        Standard standard = null; 
        
        try {                           
            standard = (Standard) session.get(Standard.class, id);            
            if (standard == null) {
                throw new DatabaseException("Invalid student Id");
            }                     
            return standard;
        } catch (HibernateException e) {                        
            throw new DatabaseException("Entered student is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    } 
   
    public List<Standard> selectStandards() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<Standard> standards = new ArrayList<Standard>();        
         
        try {
        	standards = session.createQuery("FROM Standard").list();
            if (standards.isEmpty()) {
                throw new DatabaseException("The user list is empty");
            }            
            return standards;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The users are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }   
    
         
}
     
