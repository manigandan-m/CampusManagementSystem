package com.i2i.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Period;
import com.i2i.model.User;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Period
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */

public class PeriodDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    /**
     * Saves the period model object to the database by passing it
     * 
     * @param period
     *     model object of class Period
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public void insertPeriod(Period period) throws DatabaseException {
    	Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try { 
        	session.save(period);            
            transaction.commit();        
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered period is not added.", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    /**
     * Deletes the period model object by passing periodId 
     * @param periodId
     *     id of the period to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public void deletePeriodById(int periodId) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Period period = (Period) session.get(User.class, periodId); 
            session.delete(period);
            transaction.commit();            
        } catch (IllegalArgumentException e) {      
        	System.out.println(e);
            throw new DatabaseException("Entered user is not deleted. Kindly try again with vaild user id", e);
        } finally {
            session.close();
        }                            
    }
    
    /**
     * Edits the period details by accessing the database, passing the Period class object.
     * 
     * @param period
     *     object of Period class to edit
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editPeriod(Period period)
            throws DatabaseException {
	    Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(period);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
              throw new DatabaseException("Please check the data you have given..." , e);  
       } finally {
             session.close(); 
       }
    }
    
    /**
     * Retrieves the period object by passing id of the period
     * 
     * @param id
     *     id of the period whose record has to be viewed
     * @return period
     *    object of class Period
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public Period findPeriodById(int id) throws DatabaseException {
         Period period = null;
         Session session = sessionFactory.openSession();
         Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             period = (Period)session.get(Period.class, id); 
             transaction.commit();
             return period;
         } catch (HibernateException e) {
             System.out.println("Exception : " +e);
             throw new DatabaseException("Check period ID, please enter different id", e);  
         } finally {
             session.close();
             
         } 
    }
    
    /**
     * Retrieves  the list of periods from the database
     * 
     * @return periods
     *     ArrayList of periods
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Period> retrievePeriods() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<Period> periods = new ArrayList<Period>();        
         
        try {
        	periods = session.createQuery("FROM Period").list();
            if (periods.isEmpty()) {
                throw new DatabaseException("The user list is empty");
            }            
            return periods;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The users are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }
}