package com.i2i.service;

import java.util.List;

import com.i2i.dao.UserDao;
import com.i2i.model.User;
import com.i2i.model.Address;
import com.i2i.exception.DatabaseException;

public class UserService {
    UserDao userDao = new UserDao();
    

    public void addUser(User user) throws DatabaseException {                 
            userDao.insertUser(user);                     
    }
    
    public void addAddress(Address address) throws DatabaseException {                 
        userDao.insertAddress(address);                     
    }
    

    public User searchUser(String username) throws DatabaseException {
        return (userDao.findUser(username));        
    }
    
 
    public void removeUser(String username) throws DatabaseException {
        userDao.deleteUser(username);  
    }
    
    
    public List<User> getUsers() throws DatabaseException {
        return (userDao.selectUsers());
    }

}
