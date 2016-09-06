package com.i2i.service;

import java.util.List;

import com.i2i.dao.StudentDao;
import com.i2i.model.Student;
import com.i2i.exception.DatabaseException;

public class StudentService {
    StudentDao studentDao = new StudentDao();
    

    public void addStudent(Student student) throws DatabaseException {                 
            studentDao.insertStudent(student);                     
    }
    

    public Student searchStudent(int id) throws DatabaseException {
        return (studentDao.findStudent(id));        
    }
    
 
    public void removeStudent(int id) throws DatabaseException {
        studentDao.deleteStudent(id);  
    }
    
    
    public List<Student> getStudents() throws DatabaseException {
        return (studentDao.selectStudents());
    }
     
    
       
}
        
        

