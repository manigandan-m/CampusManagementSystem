package com.i2i.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <p>
 * HibernateConnection class creates session factory object in singleton pattern.
 * </p>
 *
 * @author Manigandan 
 *
 * @created 2015-08-27
 */
public class HibernateConnection {

    public SessionFactory sessionFactory = null;
    public static HibernateConnection hibernateConnection = null;

    /**
     * <p>
     * Creates a new HibernateConnection without the values.
     * </p>
     *
     */ 
    private HibernateConnection() {
    }

    /**
     * <p>
     * Instantiate HibernateConnection class if it is not already done and return it.    
     * </p>
     *       
     * @return hibernateConnection
     *     hibernateConnection holds the object of HibernateConnection
     */
    public static HibernateConnection createObject() {
        if (null == hibernateConnection) {
            hibernateConnection = new HibernateConnection(); 
        }
        return hibernateConnection;       
    }

    /**
     * <p>
     * Creates the SessionFactory object with mapping xml file if it is not already created and return it.    
     * </p>
     *       
     * @return sessionFactory
     *     sessionFactory holds the object of SessionFactory
     */
    public SessionFactory getConnection() {
       if (null == sessionFactory) {
           try {
        	   sessionFactory = new AnnotationConfiguration().configure("CampusManagement.cfg.xml").buildSessionFactory();  
           } catch (Exception e) {
               System.err.println(e.getMessage());
           }
       } 
       return sessionFactory;       
    }
} 
    
