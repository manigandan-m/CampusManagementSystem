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

public class TeacherDao {
		HibernateConnection hibernateConnection = HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.getConnection();     

	    
	    public void insertTeacher(Teacher teacher) throws DatabaseException {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        try {                          
	            session.save(teacher);            
	            transaction.commit();        
	        } catch (HibernateException e) {   
	            throw new DatabaseException("Entered teacher is not added. Teacher ID already exits..", e);
	        } finally {
	            session.close();
	        }                                                                         
	    }
	    
	    
	    public Teacher findTeacher(int id) throws DatabaseException {        
	        Session session = sessionFactory.openSession();        
	        Teacher teacher = null; 
	        
	        try {                           
	        	teacher = (Teacher) session.get(Teacher.class, id);            
	            if (teacher == null) {
	                throw new DatabaseException("Invalid student Id");
	            }                     
	            return teacher;
	        } catch (HibernateException e) {                        
	            throw new DatabaseException("Entered teacher is not found. Kindly try again with vaild input data", e);
	        } finally {
	            session.close();
	        }                          
	    }

	   
	    public void deleteTeacher(int id) throws DatabaseException {
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
	    
	    
	    public List<Teacher> selectTeachers() throws DatabaseException {
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

