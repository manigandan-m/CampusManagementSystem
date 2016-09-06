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
    

    public User searchUser(int id) throws DatabaseException {
        return (userDao.findUser(id));        
    }
    
 
    public void removeUser(int id) throws DatabaseException {
        userDao.deleteUser(id);  
    }
    
    
    public List<User> getUsers() throws DatabaseException {
        return (userDao.selectUsers());
    }

}
