package com.i2i.service;

import java.util.List;

import com.i2i.dao.TeacherDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Teacher;
import com.i2i.model.User;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Role by invoking TeacherDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class TeacherService {
	TeacherDao teacherDao = new TeacherDao();
    
	/**
     * Calls the TeacherDao class method to add the standard to the database by passing the Teacher class object
     * 
     * @param teacher
     *     object of class Teacher
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
	public void addTeacher(Teacher teacher, User user) throws DatabaseException {                 
        teacherDao.insertTeacher(teacher, user);                    
    }
    
    /**
     * Returns the teacher model object by passing the id of teacher
     * 
     * @param id
     *     id of teacher
     * @return
     *     object of class Teacher
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Teacher getTeacherById(int id) throws DatabaseException {
        return (teacherDao.findTeacherById(id));        
    }
    
    /**
     * Invokes the TeacherDao class method to delete teacher using id
     * 
     * @param id
     *     id of the teacher to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeTeacherById(int id) throws DatabaseException {
    	teacherDao.deleteTeacherById(id);  
    }
    
    /**
     * Invokes the teacherDao method to edit the teacher details by passing the Teacher class object
     * 
     * @param teacher
     *     object of Teacher class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editTeacher(Teacher teacher)
            throws DatabaseException {
	    teacherDao.editTeacher(teacher);
    }
    
    /**
     * Invokes the TeacherDao class method to get the list of all of teachers
     *  
     * @return 
     *     list of teachers returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Teacher> getTeachers() throws DatabaseException {
        return (teacherDao.retrieveTeachers());
    }
}