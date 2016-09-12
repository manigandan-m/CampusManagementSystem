package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.exception.DatabaseException;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.connection.HibernateConnection;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model subject
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class PeriodSubjectDetailDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();
    
 
        
        /**
         * Saves the periodSubjectDetail model object to the database by passing the PeriodSubjectDetail class object
         * 
         * @param periodSubjectDetail
         *     model object of class PeriodSubjectDetail
         * @throws DataBaseException
         *     if there is an error in getting the object like NullPointerException,
         *     NumberFormatException, HibernateException
         *     
         */
        public void insertPeriodSubjectDetail(PeriodSubjectDetail periodSubjectDetail) throws DatabaseException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            try {                          
                session.save(periodSubjectDetail);            
                transaction.commit();        
            } catch (HibernateException e) {   
                throw new DatabaseException("Entered subject is not added. Subject ID already exits..", e);
            } finally {
                session.close();
            }                                                                         
        }
        
        /**
         * Retrieves the periodsubject object by passing periodsubjectId of the periodsubject
         * 
         * @param periodSubjectId
         *     id of the periodsubject whose record has to be viewed
         * @return periodSubjectDetail
         *    object of class PeriodSubjectDetail
         * @throws DataBaseException
         *     if there is an error in getting the object like NullPointerException,
         *     NumberFormatException, HibernateException
         */
        public PeriodSubjectDetail findPeriodSubjectByPeriodSubjectId(int periodSubjectId) throws DatabaseException {        
            Session session = sessionFactory.openSession();        
            PeriodSubjectDetail periodSubjectDetail = null; 
            
            try {                           
            	periodSubjectDetail = (PeriodSubjectDetail) session.get(PeriodSubjectDetail.class, periodSubjectId);            
                if (periodSubjectDetail == null) {
                    throw new DatabaseException("Invalid student Id");
                }                     
                return periodSubjectDetail;
            } catch (HibernateException e) {                        
                throw new DatabaseException("Entered subject is not found. Kindly try again with vaild input data", e);
            } finally {
                session.close();
            }                          
        }
        
        /**
         * Deletes the periodsubjectdetail model object by passing periodsubjectId 
         * @param periodsubjectId
         *     id of the periodsubject whose record has to be viewed
         * @throws DataBaseException
         *     if there is an error in getting the object like NullPointerException,
         *     NumberFormatException, HibernateException
         */
        public void deletePeriodSubjectDetailByPeriodSubjectId(int periodsubjectId) throws DatabaseException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            try {
            	PeriodSubjectDetail periodSubjectDetail = (PeriodSubjectDetail) session.get(PeriodSubjectDetail.class, periodsubjectId); 
                session.delete(periodSubjectDetail);
                transaction.commit();            
            } catch (IllegalArgumentException e) {                       
                throw new DatabaseException("Entered subject is not deleted. Kindly try again with vaild student id", e);
            } finally {
                session.close();
            }                            
        }
        
        /**
         * Edits the periodsubject details by accessing the database, passing the PeriodSubjectDetail class object.
         * 
         * @param periodSubjectDetail
         *     object of periodSubjectDetail class to edit
         * @throws DatabaseException
         *     if there is an error in getting the object like NullPointerException,
         *     NumberFormatException, HibernateException
         */
        public void editPeriodSubjectDetail(PeriodSubjectDetail periodSubjectDetail)
                throws DatabaseException {
    	    Session session = sessionFactory.openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(periodSubjectDetail);
                transaction.commit();                                                                    
            } catch (HibernateException e) {
                  throw new DatabaseException("Please check the data you have given..." , e);  
           } finally {
                 session.close(); 
           }
        }
        
        /**
         * Retrieves  the list of periodsubjectdetails from the database
         * 
         * @return periodSubjectDetails
         *     ArrayList of periodsubjectdetails
         * @throws DataBaseException
         *     if there is an error in getting the object like NullPointerException,
         *     NumberFormatException, HibernateException
         */
        public List<PeriodSubjectDetail> retrievePeriodSubjectDetails() throws DatabaseException {
            Session session = sessionFactory.openSession();        
            List<PeriodSubjectDetail> periodSubjectDetails = new ArrayList<PeriodSubjectDetail>();        
             
            try {
            	periodSubjectDetails = session.createQuery("FROM PeriodSubjectDetail").list();
                if (periodSubjectDetails.isEmpty()) {
                    throw new DatabaseException("The student list is empty");
                }            
                return periodSubjectDetails;              
            } catch (HibernateException e) {            
                throw new DatabaseException("The subjects are not viewed. Kindly try again with vaild input data", e);
            } finally {
                session.close();
            }                      
        }

}

