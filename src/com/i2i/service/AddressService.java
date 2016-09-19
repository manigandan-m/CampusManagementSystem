package com.i2i.service;

import java.util.List;

import com.i2i.dao.AddressDao;
import com.i2i.model.Address;
import com.i2i.model.User;

import com.i2i.exception.DatabaseException;

/**
 * <p>
 * Service which is used to perform basic create update, retrieve, retrieve all and delete operations
 * for model Role by invoking AddressDao class methods
 * </p>
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */
public class AddressService {
    AddressDao addressDao = new AddressDao();
	
    /**
     * Calls the AddressDao class method to add the standard to the database by passing the Address class object
     * 
     * @param address
     *     address is the particulars of a place where a person lives
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addAddress(Address address, User user) throws DatabaseException {                 
        addressDao.insertAddress(address, user);                     
    }
	
    /**
     * Invokes the addressDao method to edit the address details by passing the Address class object
     * 
     * @param address
     *     address is the particulars of a place where a person lives
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void editAddress(Address address)
            throws DatabaseException {
	    addressDao.editAddress(address);
    }
    
    /**
     * Invokes the AddressDao class method to get the list of all of addresss
     *  
     * @return 
     *     list of addresses returned
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Address> getAddresses() throws DatabaseException {
    	return addressDao.retrieveAddresses();
    }
    
    /**
     * It returns the object of Address class by passing the id of address
     * Invokes the AddressDao method to get the address object
     * 
     * @param addressId
     *     ID of address passed as argument to get the address
     * @return
     *     address of a person
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Address getAddressById(int addressId) throws DatabaseException {
        return (addressDao.retrieveAddressById(addressId));        
    }
}
