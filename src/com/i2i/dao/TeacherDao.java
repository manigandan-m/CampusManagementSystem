package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Teacher;
import com.i2i.model.User;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Teacher
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */
public class TeacherDao {
    HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    /**
     * Saves the teacher to the database by passing it
     * 
     * @param teacher
     *     teacher is a person who teaches in school
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public void insertTeacher(Teacher teacher, User user) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {           
            teacher.setUser(user);
            session.save(teacher);           
            transaction.commit();       
        } catch (HibernateException e) {
            throw new DatabaseException("Entered teacher is not added. Teacher ID already exits..", e);
        } finally {
            session.close();
        }                                                                        
    }
        
    /**
     * Retrieves the teacher by passing id of the teacher
     * 
     * @param id
     *     id of the teacher whose record has to be viewed
     * @return teacher
     *     teacher is a person who teaches in school
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public Teacher findTeacherById(int id) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        try {
            Teacher teacher = (Teacher) session.get(Teacher.class, id);            
            if (null == teacher) {
                throw new DatabaseException("Invalid teacher Id");
            } 
            return teacher;
        } catch (HibernateException e) { 
                throw new DatabaseException("Entered teacher is not found. Kindly try again with vaild input data", e);
        } finally {
              session.close();
        }                          
    }

    /**
     * Deletes the teacher by passing teacherId 
     * 
     * @param teacherId
     *     id of the teacher to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public void deleteTeacherById(int id) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Teacher teacher = (Teacher) session.get(Teacher.class, id); 
            session.delete(teacher);
            transaction.commit();            
        } catch (IllegalArgumentException e) {                       
              throw new DatabaseException("Entered teacher is not deleted. Kindly try again with vaild student id", e);
        } finally {
              session.close();
        }                            
    }
        
    /**
     * Edits the teacher details by accessing the database.
     * 
     * @param teacher
     *     teacher is a person who teaches in school
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editTeacher(Teacher teacher)
                throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(teacher);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
              throw new DatabaseException("Please check the data you have given..." , e);  
        } finally {
              session.close(); 
        }
    }
        
    /**
     * Retrieves  the list of teachers from the database
     * 
     * @return teachers
     *     List of teachers
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Teacher> retrieveTeachers() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        try {
            List<Teacher> teachers = session.createQuery("FROM Teacher").list();
            if (teachers.isEmpty()) {
                throw new DatabaseException("The teacher list is empty");
            }            
            return teachers;              
        } catch (HibernateException e) {            
              throw new DatabaseException("The teachers are not viewed. Kindly try again with vaild input data", e);
        } finally {
              session.close();
        }                      
    }   
}
