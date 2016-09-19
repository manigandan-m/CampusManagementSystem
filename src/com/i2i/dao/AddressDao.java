package com.i2i.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.i2i.model.Address;
import com.i2i.model.User;
import com.i2i.exception.DatabaseException;
import com.i2i.connection.HibernateConnection;

/**
 * <p>
 * DataAccessObject(Dao) which is used to perform create operation for model Address
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2015-08-27
 */
public class AddressDao {
	HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory sessionFactory = hibernateConnection.getConnection();   
    
    /**
     * Saves the address model object to the database by passing it
     * 
     * @param address
     *     object of the Address class to be inserted
     * @throws DatabaseException
     */
    public void insertAddress(Address address, User user) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            address.setUser(user);
            session.save(address);           
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Entered address is not added. ..", e);
        } finally {
            session.close();
        }                                                                         
    }
	
	/**
     * Deletes the address model object by passing id 
     * @param id
     *     id of the address
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void deleteAddressById(int id) throws DatabaseException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Address address = (Address)session.get(Address.class, id); 
            session.delete(address); 
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Check the address Id...\n", e);  
        } finally {
            session.close(); 
        }
    }
	
	/**
     * Edits the address details by accessing the database, passing the Address class object.
     * 
     * @param address
     *     object of Address class to edit
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editAddress(Address address)
            throws DatabaseException {
	    Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(address);
            transaction.commit();                                                                    
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e);  
       } finally {
             session.close(); 
       }
    }
    
    /**
     * Retrieves the address object by passing id of the address
     * 
     * @param id
     *     id of the address whose record has to be viewed
     * @return address
     *    object of class Address
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public Address retrieveAddressById(int id) throws DatabaseException {
         Address address = null;
         Session session = sessionFactory.openSession();
         Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             address = (Address)session.get(Address.class, id); 
             transaction.commit();
             return address;
         } catch (HibernateException e) {
             throw new DatabaseException("Check address ID, please enter different id", e);  
         } finally {
             session.close();
             
         } 
    }
    
    /**
     * Retrieves  the list of address from the database
     * 
     * @return addresses
     *     ArrayList of address
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public List<Address> retrieveAddresses() throws DatabaseException {
        List<Address> addresses = new ArrayList<Address>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            addresses = session.createQuery("FROM Address").list(); 
            return addresses;
        } catch (HibernateException e) {
            throw new DatabaseException("Data is not present at the moment...", e); 
        } finally {
            session.close(); 
        }		
    }
}