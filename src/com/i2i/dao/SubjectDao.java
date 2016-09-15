package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Subject;
import com.i2i.model.Teacher;
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
public class SubjectDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();
    
    /**
     * Saves the subject model object to the database by passing the Subject class object
     * 
     * @param subject
     *     model object of class Subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     *     
     */
    public void insertSubject(Subject subject) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {                          
            session.save(subject);            
            transaction.commit();        
        } catch (HibernateException e) {   
            throw new DatabaseException("Entered subject is not added. Subject ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    /**
     * Retrieves the subject object by passing subject code of the subject
     * 
     * @param subjectCode
     *     code of the subject whose record has to be viewed
     * @return subject
     *    object of class Subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public Subject findSubjectBySubjectCode(String subjectCode) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        Subject subject = null; 
        
        try {                           
        	subject = (Subject) session.get(Subject.class, subjectCode);            
            if (subject == null) {
                throw new DatabaseException("Invalid student Id");
            }                     
            return subject;
        } catch (HibernateException e) {                        
            throw new DatabaseException("Entered subject is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    }
    
    /**
     * Deletes the subject model object by passing subjectcode 
     * @param subjectCode
     *     code of the subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void deleteSubjectBySubjectCode(String subjectCode) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
        	Subject subject = (Subject) session.get(Subject.class, subjectCode); 
            session.delete(subject);
            transaction.commit();            
        } catch (IllegalArgumentException e) {                       
            throw new DatabaseException("Entered subject is not deleted. Kindly try again with vaild student id", e);
        } finally {
            session.close();
        }                            
    }
    
    /**
     * Edits the subject details by accessing the database, passing the Subject class object.
     * 
     * @param subject
     *     object of Subject class to edit
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editSubject(Subject subject)
            throws DatabaseException {
	    Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(subject);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
              throw new DatabaseException("Please check the data you have given..." , e);  
       } finally {
             session.close(); 
       }
    }
    
    /**
     * Retrieves  the list of subjects from the database
     * 
     * @return subjects
     *     ArrayList of subjects
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public List<Subject> retrieveSubjects() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<Subject> subjects = new ArrayList<Subject>();        
         
        try {
        	subjects = session.createQuery("FROM Subject").list();
            if (subjects.isEmpty()) {
                throw new DatabaseException("The student list is empty");
            }            
            return subjects;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The subjects are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }
    
    
    public void updateSubjectByTeacher(Subject subject, Teacher teacher) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            subject.setTeacher(teacher);            
            session.update(subject);            
            transaction.commit();                                                                   
        } catch (HibernateException e) {
        	e.printStackTrace();
              throw new DatabaseException("Please check the data you have given..." , e); 
       } finally {
             session.close();
       }
    }
}
