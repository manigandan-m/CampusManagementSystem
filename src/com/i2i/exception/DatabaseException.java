package com.i2i.exception;

import java.lang.Exception;

public class DatabaseException  extends Exception {
	
	 public DatabaseException (String message) {
	        super(message);
	    } 
	    
	    public DatabaseException (String message, Throwable cause) {
	        super(message, cause);
	    }

}
