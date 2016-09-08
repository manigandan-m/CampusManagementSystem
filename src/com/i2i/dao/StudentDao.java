package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.Address;
import com.i2i.model.Student;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;


public class StudentDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    
    public void insertStudent(Student student) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {                          
            session.save(student);            
            transaction.commit(); 
            
            //insertUserToStudent(studentId);
        } catch (HibernateException e) {   
        	e.printStackTrace();
            throw new DatabaseException("Entered student is not added. Student ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }
    
    public void insertUserToStudent(int studentId, int userId) throws DatabaseException {
    	
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {      	
       
    	Student student = (Student) session.get(Student.class, studentId);
    	User user = (User) session.get(User.class, userId);
        student.setUser(user);
        session.update(user);            
        transaction.commit();  
    } catch (HibernateException e) { 
    	System.out.println(e);
        throw new DatabaseException("Entered student is not added to user. ..", e);
    } finally {
        session.close();
    }  
    } 
    
    
    public Student findStudent(int id) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        Student student = null; 
        
        try {                           
            student = (Student) session.get(Student.class, id);            
            if (student == null) {
                throw new DatabaseException("Invalid student Id");
            }                     
            return student;
        } catch (HibernateException e) {                        
            throw new DatabaseException("Entered student is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    }

   
    public void deleteStudent(int id) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Student student = (Student) session.get(Student.class, id); 
            session.delete(student);
            transaction.commit();            
        } catch (IllegalArgumentException e) {                       
            throw new DatabaseException("Entered student is not deleted. Kindly try again with vaild student id", e);
        } finally {
            session.close();
        }                            
    }   
    
    
    public List<Student> selectStudents() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<Student> students = new ArrayList<Student>();        
         
        try {
            students = session.createQuery("FROM Student").list();
            if (students.isEmpty()) {
                throw new DatabaseException("The student list is empty");
            }            
            return students;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The students are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }   
    
         
}
     
