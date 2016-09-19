package com.i2i.service;

import java.util.List;

import com.i2i.dao.StudentDao;
import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Role by invoking StudentDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class StudentService {
    StudentDao studentDao = new StudentDao();
    
    /**
     * Calls the StudentDao class method to add the standard to the database by passing the Student class object
     * 
     * @param student
     *     object of class Student
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addStudent(Student student, User user, Standard standard) throws DatabaseException {                 
        studentDao.insertStudent(student, user, standard);                     
    }
    
    /**
     * Returns the student model object by passing the id of student
     * 
     * @param id
     *     id of student
     * @return
     *     object of class Student
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Student getStudentById(int id) throws DatabaseException {
        return (studentDao.findStudentById(id));        
    }
    
    /**
     * Invokes the StudentDao class method to delete student using id
     * 
     * @param id
     *     id of the student to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeStudentById(int id) throws DatabaseException {
        studentDao.deleteStudentById(id);  
    }
    
    /**
     * Invokes the studentDao method to edit the student details by passing the Student class object
     * 
     * @param student
     *     object of Student class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void editStudent(Student student)
            throws DatabaseException {
	    studentDao.editStudent(student);
    }
    
    /**
     * Invokes the StudentDao class method to get the list of all of students
     *  
     * @return 
     *     list of students returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Student> getStudents() throws DatabaseException {
        return (studentDao.retrieveStudents());
    }
}