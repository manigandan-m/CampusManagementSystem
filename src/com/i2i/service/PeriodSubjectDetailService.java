package com.i2i.service;

import java.util.List;

import com.i2i.dao.PeriodSubjectDetailDao;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.model.Subject;
import com.i2i.exception.DatabaseException;
/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Subject by invoking SubjectDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class PeriodSubjectDetailService {
	PeriodSubjectDetailDao periodSubjectDetailDao = new PeriodSubjectDetailDao();
    
	 /**
     * Calls the SubjectDao class method to add the subject to the database by passing the Subject class object
     * 
     * @param subject
     *     model object of class Subject
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addPeriodSubjectDetail(PeriodSubjectDetail periodSubjectDetail) throws DatabaseException {                 
    	periodSubjectDetailDao.insertPeriodSubjectDetail(periodSubjectDetail);                     
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
    public PeriodSubjectDetail getPeriodSubjectDetailByPeriodSubjectId(int periodSubjectId) throws DatabaseException {
        return (periodSubjectDetailDao.findPeriodSubjectByPeriodSubjectId(periodSubjectId));        
    }
    
    /**
     * Invokes the PeriodSubjectDetailDao class method to delete periodsubjectdetail using periodSubjectId
     * 
     * @param periodSubjectId
     *     id of the periodsubjectdetail to delete
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removePeriodSubjectByPeriodSubjectId(int periodSubjectId) throws DatabaseException {
    	periodSubjectDetailDao.deletePeriodSubjectDetailByPeriodSubjectId(periodSubjectId);  
    }
}