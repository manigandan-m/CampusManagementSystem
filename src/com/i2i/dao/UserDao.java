package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.User;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create, retrieve, retrieve all, delete operations for model User
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Manigandan
 * 
 * @created 2015-08-27
 */
public class UserDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();    

    /**
     * Saves the user model object to the database by passing it
     * 
     * @param user
     *     model object of class User
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     *     
     */
    public int insertUser(User user) throws DatabaseException {
        System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try {         
            int userId = (Integer)session.save(user);           
            transaction.commit();
            return userId;
        } catch (HibernateException e) {
            System.out.println(e);
            throw new DatabaseException("Entered user is not added. User ID already exits..", e);
        } finally {
            session.close();
        }                                                                         
    }   
    
    /**
     * Retrieves the user model object by passing username of the user
     * 
     * @param username
     *     username of the user whose record has to be viewed
     * @return user
     *    object of class User
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public User findUserByUsername(String username) throws DatabaseException {        
        Session session = sessionFactory.openSession();        
        try {                
        	List<User> users = session.createQuery("FROM User where username= '"+username+"'").list();
            if (users.isEmpty()) {
            	throw new DatabaseException("Invalid username");
            }                     
            return users.get(0);
        } catch (HibernateException e) { 
        	System.out.println(e);
        	e.printStackTrace();
            throw new DatabaseException("Entered user is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                          
    }
    
    /**
     * Retrieves the user model object by passing userId of the user
     * 
     * @param id
     *     id of the user whose record has to be viewed
     * @return user
     *    object of class User
     * @throws DatabaseException
     *     if there is an error in getting the object like HibernateException
     */
    public User findUserById(int id) throws DatabaseException {       
        Session session = sessionFactory.openSession();       
        User user = null;
       
        try {                          
            user = (User) session.get(User.class, id);           
            if (user == null) {
               
                throw new DatabaseException("Invalid user Id");
            }                    
            return user;
        } catch (HibernateException e) {
            System.out.println(e);
            throw new DatabaseException("Entered user is not found. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                         
    }
    
    /**
     * Edits the user details by accessing the database, passing the User class object.
     * 
     * @param user
     *     object of User class to edit
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editUser(User user)
            throws DatabaseException {
	    Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
        	System.out.println(e);
              throw new DatabaseException("Please check the data you have given..." , e);  
       } finally {
             session.close(); 
       }
    }
    
    /*public void insertAddressToUser(int addressId, int userId) throws DatabaseException {
    	System.out.println("session");
        Session session = sessionFactory.openSession();
        System.out.println("session created");
        Transaction transaction = session.beginTransaction();
        try {       	
       
    	Address address = (Address) session.get(Address.class, addressId);
    	User user = (User) session.get(User.class, userId);
        user.setAddress(address);
        session.update(user);            
        transaction.commit();  
    } catch (HibernateException e) { 
    	System.out.println(e);
        throw new DatabaseException("Entered address is not added to user. ..", e);
    } finally {
        session.close();
    }  
    }*/ 
    
   /**
    * Retrieves  the list of users from the database
    *  
    * @return users
    *     List of all users in the database 
    * @throws DatabaseException
    *     if there is an error in getting the object like HibernateException
    */
   public List<User> retrieveUsers() throws DatabaseException {
        Session session = sessionFactory.openSession();        
        List<User> users = new ArrayList<User>();        
         
        try {
            users = session.createQuery("FROM User").list();
            if (users.isEmpty()) {
                throw new DatabaseException("The user list is empty");
            }            
            return users;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The users are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
   }   
}