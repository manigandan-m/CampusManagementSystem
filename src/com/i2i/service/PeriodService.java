package com.i2i.service;

import java.util.List;

import com.i2i.dao.PeriodDao;
import com.i2i.model.Period;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;

public class PeriodService {
    PeriodDao periodDao = new PeriodDao();
    
    public void addPeriod(Period period) throws DatabaseException {                 
        periodDao.insertPeriod(period);                     
    }
    
    public void removePeriod(int periodId) throws DatabaseException {
    	periodDao.deletePeriod(periodId);  
    }
    
    public List<Period> getPeriods() throws DatabaseException {
        return (periodDao.selectPeriods());
    }
}