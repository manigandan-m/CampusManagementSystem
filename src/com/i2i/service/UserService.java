package com.i2i.service;

import java.util.List;

import com.i2i.dao.UserDao;
import com.i2i.model.User;
import com.i2i.model.Address;
import com.i2i.exception.DatabaseException;

public class UserService {
    UserDao userDao = new UserDao();
    

    public int addUser(User user) throws DatabaseException {                 
            return (userDao.insertUser(user));                     
    }     

    public User searchUser(String username) throws DatabaseException {
        return (userDao.findUser(username));        
    }    
    
    public List<User> getUsers() throws DatabaseException {
        return (userDao.selectUsers());
    }
    
    public User searchUser(int id) throws DatabaseException {
        return (userDao.findUser(id));        
    }
    
}