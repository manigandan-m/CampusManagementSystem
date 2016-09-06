package com.i2i.service;

import java.util.List;

import com.i2i.dao.TeacherDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Teacher;

public class TeacherService {
	TeacherDao teacherDao = new TeacherDao();
    

    public void addTeacher(Teacher teacher) throws DatabaseException {                 
    	teacherDao.insertTeacher(teacher);                     
    }
    

    public Teacher searchTeacher(int id) throws DatabaseException {
        return (teacherDao.findTeacher(id));        
    }
    
 
    public void removeTeacher(int id) throws DatabaseException {
    	teacherDao.deleteTeacher(id);  
    }
    
    
    public List<Teacher> getTeachers() throws DatabaseException {
        return (teacherDao.selectTeachers());
    }
}
