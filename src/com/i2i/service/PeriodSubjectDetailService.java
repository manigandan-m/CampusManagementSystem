package com.i2i.service;

import java.util.ArrayList;
import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.PeriodSubjectDetail;
import com.i2i.model.Standard;
import com.i2i.model.Subject;
import com.i2i.dao.PeriodSubjectDetailDao;

/**
 * <p>
 * Service which is used to generate the time table of standard and
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2016-09-15
 */
public class PeriodSubjectDetailService {
    PeriodSubjectDetailDao periodSubjectDetailDao = new PeriodSubjectDetailDao();
    StandardService standardService = new StandardService();
	
    /**
     * <p>
     * Gets standard id whose time table has to be generated
     * Calls allocateSubjectToPeriod function to allocate subjects to periods
     * Then calls generatePeriods function to generate the period objects of timetable
     * Finally calls addPeriodSubjectDetails to store the period objects of timetable
     * </p>
     * 
     * @param standardId
     *     standardId holds the id of standard whose time table has to be generated
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException    
     */
    public void generateTimeTable(int standardId) throws DatabaseException {
        Standard standard = standardService.getStandardById(standardId);
        List<Subject> subjects = standard.getSubjects();                    
        generatePeriods(allocateSubjectToPeriod(subjects));        
	}	
	
    /**
     * Gets the list of subjects of standard and generate the list of periods with subject code
     * 
     * @param subjects
     *     subjects holds the list of subjects
     * @return periods
     *     periods holds the list of periods with subject code       
     */
    public List<Subject> allocateSubjectToPeriod(List<Subject> subjects) {
        List<Subject> periods = new ArrayList<Subject>();
	periods.add(0,null);
	periods.add(1,subjects.get(0));
	periods.add(2,subjects.get(1));
	periods.add(3,subjects.get(2));
	periods.add(4,subjects.get(3));
	periods.add(5,subjects.get(4));
	periods.add(6,subjects.get(1));
	periods.add(7,subjects.get(0));
	periods.add(8,subjects.get(2));
	periods.add(9,subjects.get(3));
	periods.add(10,subjects.get(0));
	periods.add(11,subjects.get(4));
	periods.add(12,subjects.get(1));
	periods.add(13,subjects.get(2));
	periods.add(14,subjects.get(4));
	periods.add(15,subjects.get(3));
	periods.add(16,subjects.get(0));		
	periods.add(17,subjects.get(1));		
	periods.add(18,subjects.get(2));		
	periods.add(19,subjects.get(3));		
	periods.add(20,subjects.get(4));				
	return periods;
    }
	
    /**
     * Gets the list of periods with period id as index and generate the list of PeriodSubjectDetail objects then return it
     * 
     * @param periods
     *     periods holds the list of periods with subject code 
     * @return periodSubjectDetails
     *     periodSubjectDetails holds the list of periods with subject code, teacher id and standard id       
     */
    public List<PeriodSubjectDetail> generatePeriods(List<Subject> periods) throws DatabaseException {
       	PeriodSubjectDetail periodSubjectDetail = new PeriodSubjectDetail();
        List<PeriodSubjectDetail> periodSubjectDetails = new ArrayList<PeriodSubjectDetail>();
        int i = 1;			
	while (i<= 20) {
	    Subject subject = periods.get(i);				
	    periodSubjectDetail.setPeriodId(i);				
	    periodSubjectDetail.setSubjectCode(subject.getSubjectCode());				
	    periodSubjectDetail.setStandard(subject.getStandard());
	    periodSubjectDetail.setTeacher(subject.getTeacher());
	    periodSubjectDetails.add(periodSubjectDetail);
	    periodSubjectDetailDao.insertPeriodSubjectDetail(periodSubjectDetail);   
	    i++;												
        }
	return periodSubjectDetails;
    }	 
    
    /**
     * Gets the standard id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param standardId
     *     standardId holds the id of standard for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<PeriodSubjectDetail> getPeriodSubjectDetailsByStandardId(int standardId) throws DatabaseException {
        return (periodSubjectDetailDao.retrievePeriodSubjectDetailsByStandardId(standardId));        
    }
    
    /**
     * Gets the teacher id whose time table has to be retrieved and sends to PeriodSubjectDetail Dao    
     * 
     * @param teacherId
     *     teacherId holds the id of teacher for which the periods have to be retrieved
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<PeriodSubjectDetail> getPeriodSubjectDetailsByTeacherId(int teacherId) throws DatabaseException {
    	List<PeriodSubjectDetail> teacherPeriods = new ArrayList<PeriodSubjectDetail>();
    	List<PeriodSubjectDetail> periodSubjectDetails = periodSubjectDetailDao.retrievePeriodSubjectDetailsByTeacherId(teacherId);
    	PeriodSubjectDetail periodSubjectDetail = null;
    	int i = 0;			
	while (i<= 20) {		    
	    teacherPeriods.add(periodSubjectDetail);			
	    i++;												
        }		
    	teacherPeriods.add(periodSubjectDetails.get(0).getPeriodId(),periodSubjectDetails.get(0));    	
    	teacherPeriods.add(periodSubjectDetails.get(1).getPeriodId(),periodSubjectDetails.get(1));    	
    	teacherPeriods.add(periodSubjectDetails.get(2).getPeriodId(),periodSubjectDetails.get(2));    	
    	teacherPeriods.add(periodSubjectDetails.get(3).getPeriodId(),periodSubjectDetails.get(3));
    	return (teacherPeriods);        
    }    
}