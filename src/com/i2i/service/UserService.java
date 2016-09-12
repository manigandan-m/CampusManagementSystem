package com.i2i.service;

import java.util.List;

import com.i2i.dao.UserDao;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations for model Role by invoking UserDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class UserService {
    UserDao userDao = new UserDao();
    
    /**
     * Calls the UserDao class method to add the standard to the database by passing the User class object
     * 
     * @param user
     *     object of class User
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public int addUser(User user) throws DatabaseException {                 
        return (userDao.insertUser(user));                     
    }     
    
    /**
     * Invokes the userDao method to edit the user details by passing the User class object
     * 
     * @param user
     *     object of User class
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    
    public void editUser(User user)
            throws DatabaseException {
	    userDao.editUser(user);
    }
    
    /**
     * Invokes the userDao method to find a user by passing the username of the user model object
     * 
     * @param username
     *     username of the user model object
     * @return
     *     object of User class
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public User getUserByUsername(String username) throws DatabaseException {
        return (userDao.findUserByUsername(username));        
    }
    
    /**
     * Invokes the userDao method to find a user by passing the id of the user model object
     * 
     * @param id
     *     id of the user model object
     * @return
     *     object of User class
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public User getUserById(int id) throws DatabaseException {
        return (userDao.findUserById(id));       
    }
    
    /**
     * Invokes the UserDao class method to get the list of all of users
     *  
     * @return 
     *     list of users returned in List datatype
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<User> getUsers() throws DatabaseException {
        return (userDao.retrieveUsers());
    }
}