package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.Student;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model Student
 * It allocates user model object to the student model object by assigning the id of user to the particular student
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2015-08-27
 */

public class StudentDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();     

    /**
     * Saves the student model object to the database by passing it
     * 
     * @param student
     *     model object of class Student
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public void insertStudent(Student student, User user, Standard standard) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {  
        	student.setStandard(standard);
        	student.setUser(user);
            session.save(student);            
            transaction.commit(); 
            
            
        } catch (HibernateException e) {   
        	e.printStackTrace();
            throw new DatabaseException("Entered student is not added. Student ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }  
    
    
    /**
     * Retrieves the student object by passing id of the student
     * 
     * @param id
     *     id of the student whose record has to be viewed
     * @return student
     *    object of class Student
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public Student findStudentById(int id) throws DatabaseException {        
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

    /**
     * Deletes the student model object by passing studentId 
     * 
     * @param studentId
     *     id of the student to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public void deleteStudentById(int id) throws DatabaseException {
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
    
    /**
     * Edits the student details by accessing the database, passing the Student class object.
     * 
     * @param student
     *     object of Student class to edit
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editStudent(Student student)
            throws DatabaseException {
	    Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
              throw new DatabaseException("Please check the data you have given..." , e);  
       } finally {
             session.close(); 
       }
    }
    
    /**
     * Retrieves  the list of students from the database
     * 
     * @return students
     *     ArrayList of students
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public List<Student> retrieveStudents() throws DatabaseException {
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