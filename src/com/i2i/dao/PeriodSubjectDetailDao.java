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
 * DataAccessObject(Dao) which is used to perform insert, retrieve, retrieve all, delete operations for timetable periods
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-15
 */
public class PeriodSubjectDetailDao {
    HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection(); 
     
    /**
     * Saves the periods of time table in the form of PeriodSubjectDetail
     * 
     * @param periodSubjectDetail
     *     PeriodSubjectDetail holds the period of time table
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
     * Retrieves  the list of periodsubjectdetails by standard id from the database
     *
     * @param standardId
     *     standard id whose period details have to be retrieved
     * @return periodSubjectDetails
     *     ArrayList of periodsubjectdetails
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public List<PeriodSubjectDetail> retrievePeriodSubjectDetailsByStandardId(int standardId) throws DatabaseException {
        Session session = sessionFactory.openSession();     
        List<PeriodSubjectDetail> periodSubjectDetails = new ArrayList<PeriodSubjectDetail>();     
        try {             
            periodSubjectDetails = session.createQuery("FROM PeriodSubjectDetail where standard_id ='"+standardId+"'").list();
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
     
    /**
     * Retrieves  the list of periodsubjectdetails by teacher id from the database
     *
     * @param teacherId
     *     teacher id whose period details have to be retrieved
     * @return periodSubjectDetails
     *     ArrayList of periodsubjectdetails
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public List<PeriodSubjectDetail> retrievePeriodSubjectDetailsByTeacherId(int teacherId) throws DatabaseException {
        Session session = sessionFactory.openSession();     
        List<PeriodSubjectDetail> periodSubjectDetails = new ArrayList<PeriodSubjectDetail>();            
        try {      
            periodSubjectDetails = session.createQuery("FROM PeriodSubjectDetail where teacher_id ='"+teacherId+"'").list();             
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
