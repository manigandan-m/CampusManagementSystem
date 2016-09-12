package com.i2i.service;

import java.util.List;

import com.i2i.dao.PeriodDao;
import com.i2i.model.Period;
import com.i2i.exception.DatabaseException;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Period by invoking PeriodDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class PeriodService {
    PeriodDao periodDao = new PeriodDao();
    
    /**
     * Calls the PeriodDao class method to add the period to the database by passing the Period class object
     * 
     * @param period
     *     object of class Period
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addPeriod(Period period) throws DatabaseException {                 
        periodDao.insertPeriod(period);                     
    }
    
    /**
     * Invokes the PeriodDao class method to delete period using id
     * 
     * @param id
     *     id of the period to delete
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void removePeriodById(int periodId) throws DatabaseException {
    	periodDao.deletePeriodById(periodId);  
    }
    
    /**
     * Invokes the PeriodDao class method to get period model object using id of the period
     * Returns the period model object
     * 
     * @param id
     *     id of the period
     * @return 
     *     Period model object    
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Period getPeriodById(int id) throws DatabaseException { 
    	return periodDao.findPeriodById(id); 
    }
    
    /**
     * Invokes the periodDao method to edit the period details by passing the Period class object
     * 
     * @param period
     *     object of Period class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editPeriod(Period period)
            throws DatabaseException {
	    periodDao.editPeriod(period);
    }
    
    /**
     * Invokes the PeriodDao class method to get the list of all of periods
     *  
     * @return 
     *     list of periods returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Period> getPeriods() throws DatabaseException {
        return (periodDao.retrievePeriods());
    }
}