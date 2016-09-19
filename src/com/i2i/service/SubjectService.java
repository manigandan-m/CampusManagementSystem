package com.i2i.service;

import java.util.List;

import com.i2i.dao.SubjectDao;
import com.i2i.model.Subject;
import com.i2i.model.Teacher;
import com.i2i.exception.DatabaseException;
/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Subject by invoking SubjectDao class methods
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2015-08-27
 */
public class SubjectService {
	SubjectDao subjectDao = new SubjectDao();
	TeacherService teacherService = new TeacherService();
    
	 /**
     * Calls the SubjectDao class method to add the subject to the database by passing the Subject class object
     * 
     * @param subject
     *     model object of class Subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addSubject(Subject subject) throws DatabaseException {                 
    	subjectDao.insertSubject(subject);                     
    }
    
    /**
     * Invokes the SubjectDao class method to get subject model object using subjectCode of the subject
     * Returns the subject model object
     * 
     * @param subjectCode
     *     code of the subject
     * @return 
     *     Subject model object    
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Subject getSubjectBySubjectCode(String subjectCode) throws DatabaseException {
        return (subjectDao.findSubjectBySubjectCode(subjectCode));        
    }
    
    /**
     * Invokes the SubjectDao class method to get subject model object using teacherId
     * Returns the subject model object
     * 
     * @param teacherId
     *     id of teacher
     * @return 
     *     Subject model object    
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Subject getSubjectByTeacherId(int teacherId) throws DatabaseException {
        return (subjectDao.findSubjectByTeacherId(teacherId));        
    }
    
    /**
     * Invokes the SubjectDao class method to delete subject using subjectCode
     * 
     * @param subjectCode
     *     subjectCode of the subject to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removeSubjectBySubjectCode(String subjectCode) throws DatabaseException {
    	subjectDao.deleteSubjectBySubjectCode(subjectCode);  
    }
    
    /**
     * Invokes the SubjectDao method to edit the subject details by passing the Subject class object
     * 
     * @param subject
     *     object of Subject class
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editSubject(Subject subject)
            throws DatabaseException {
	    subjectDao.editSubject(subject);
    }
    
    /**
     * Invokes the SubjectDao class method to get the list of all of subjects 
     * 
     * @return
     *     returns the list of subjects by invoking SubjectDao method
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Subject> getSubjects() throws DatabaseException {
        return (subjectDao.retrieveSubjects());
    }
    
    /**
     * <p>
     * Used to allot teacher to a subject by passing the subject object
     * Checks if the teacher object by invoking the TeacherService method by passing the teacherId
     * Invokes the SubjectDao method to allot the teacher to the subject by passing the
     *  objects of Subject class and Teacher class
     *  </p>
     *  
     * @param subject
     *     object of class Subject to which the teacher should be assigned
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void allotTeacher(Subject subject) throws DatabaseException {
    	Teacher teacher = null;
    	Subject allocateSubject = getSubjectBySubjectCode(subject.getSubjectCode());
    	int teacherId = subject.getTeacher().getTeacherId();
    	if (0 != teacherId) 
        {
        	teacher = teacherService.getTeacherById(teacherId);        	
        }
        subjectDao.updateSubjectByTeacher(allocateSubject, teacher);
    }
}
