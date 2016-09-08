package com.i2i.service;

import java.util.List;

import com.i2i.dao.StandardDao;
import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.exception.DatabaseException;

public class StandardService {
    StandardDao standardDao = new StandardDao();
    

    public void addStandard(Standard standard) throws DatabaseException {                 
            standardDao.insertStandard(standard);                     
    }         
    
    public List<Standard> getStandards() throws DatabaseException {
        return (standardDao.selectStandards());
    }
    
    public void removeStandard(int id) throws DatabaseException {
        standardDao.deleteStandard(id);  
    }
    
    public Standard searchStandard(int id) throws DatabaseException {
        return (standardDao.findStandard(id));        
    }
    
}
