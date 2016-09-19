package com.i2i.dao;

import java.util.ArrayList;
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
 * @created 2015-08-27
 */
public class TeacherDao {
    HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.getConnection();     

	/**
	* Saves the teacher model object to the database by passing it
	* 
	* @param teacher
	*     model object of class Student
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
	* Retrieves the teacher object by passing id of the teacher
	* 
	* @param id
	*     id of the teacher whose record has to be viewed
	* @return student
	*    object of class Teacher
	* @throws DatabaseException
	*     if there is an error in getting the object like HibernateException
	*/
	public Teacher findTeacherById(int id) throws DatabaseException {        
	    Session session = sessionFactory.openSession();        
	    Teacher teacher = null; 
	    try {
	    	teacher = (Teacher) session.get(Teacher.class, id);            
	        if (teacher == null) {
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
	* Deletes the teacher model object by passing teacherId 
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
	* Edits the teacher details by accessing the database, passing the Teacher class object.
	* 
	* @param teacher
	*     object of Teacher class to edit
	* @throws DataBaseException
	*     if there is an error in getting the object like NullPointerException,
	*     NumberFormatException, HibernateException
	*/
	public void editTeacher(Teacher teacher)
	            throws DatabaseException {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
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
	*     ArrayList of teachers
	* @throws DatabaseException
	*     if there is an error in getting the object like HibernateException
	*/
	public List<Teacher> retrieveTeachers() throws DatabaseException {
	    Session session = sessionFactory.openSession();        
	    List<Teacher> teachers = new ArrayList<Teacher>();        
	    try {
	        teachers = session.createQuery("FROM Teacher").list();
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