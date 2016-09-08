package com.i2i.service;

import java.util.List;

import com.i2i.dao.AddressDao;
import com.i2i.model.User;
import com.i2i.model.Address;
import com.i2i.exception.DatabaseException;

public class AddressService {
	AddressDao addressDao = new AddressDao();
	
	public void addAddress(Address address) throws DatabaseException {                 
        addressDao.insertAddress(address);                     
    } 
}
