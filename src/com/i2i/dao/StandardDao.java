package com.i2i.dao;

import java.util.List;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.Standard;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Standard
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */

public class StandardDao {
    HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();    

    /**
     * Saves the standard to the database by passing it. It also gets the list of subjects assigned to that
     * standard and stores it as a list in the Standard 
     * 
     * @param standard
     *     It is a grade in which students are taught a set of subjects
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public void insertStandard(Standard standard) throws DatabaseException {
    	Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {     	
            standard.getSubjects().get(0).setStandard(standard);
            standard.getSubjects().get(1).setStandard(standard);
            standard.getSubjects().get(2).setStandard(standard);
            standard.getSubjects().get(3).setStandard(standard);
            standard.getSubjects().get(4).setStandard(standard);
            session.save(standard);
            transaction.commit();
        } catch (HibernateException e) {
        	throw new DatabaseException("Entered user is not added. Standard ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }   
    
    /**
     * Deletes the standard model object by passing standardId 
     * 
     * @param standardId
     *     id of the standard to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public void deleteStandardById(int id) throws DatabaseException {
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
    
    /**
     * Retrieves the standard object by passing id of the standard
     * 
     * @param id
     *     id of the standard whose record has to be viewed
     * @return standard
     *    object of class Standard
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public Standard findStandardById(int id) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        try {                           
            Standard standard = (Standard) session.get(Standard.class, id);            
            if (null == standard) {
                throw new DatabaseException("Invalid student Id");
            }                     
            return standard;
        } catch (HibernateException e) {                        
            throw new DatabaseException("Entered student is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    }
    
    /**
     * Edits the standard details by accessing the database, passing the Standard class object.
     * 
     * @param standard
     *     Standard class which is to edited
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void updateStandard(Standard standard) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (0 == standard.getClassCoordinator().getTeacherId()) {
            	standard.setClassCoordinator(null);
            }
            session.update(standard);            
            transaction.commit();                                                                   
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e); 
       } finally {
            session.close();
       }
    }
    
    /**
     * Retrieves  the list of standards from the database
     * 
     * @return standards
     *     ArrayList of standards
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Standard> retrieveStandards() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        try {
            List<Standard> standards = session.createQuery("FROM Standard").list();
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
