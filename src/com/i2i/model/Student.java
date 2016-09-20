package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.User;
import com.i2i.model.Standard;

/**
 * Model class for Student
 * Student is a physical entity which reflects a person who is a pupil in a standard 
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */

@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue    
    @Column(name = "roll_number")
    private int rollNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")   
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;    

    @Column(name = "father_first_name")
    private String fatherFirstName;
    
    @Column(name = "father_last_name")
    private String fatherLastName;
    
    @Column(name = "mother_first_name")
    private String motherFirstName;
    
    @Column(name = "mother_last_name")
    private String motherLastName;
    
    @Column(name = "total_income")
    private long familyIncome;    
    
    @Column(name = "date_of_admission")
    private String dateOfAdmission;
    
    @Column(name = "admission_category")
    private String admissionCategory;
        
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "standard_id")  
    private Standard standard;
    
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }    
    
    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }
    
    public String getFatherFirstName() {
        return fatherFirstName;
    }
    
    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }
    
    public String getFatherLastName() {
        return fatherLastName;
    }
    
    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }
    
    public String getMotherFirstName() {
        return motherFirstName;
    }
    
    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }
    
    public String getMotherLastName() {
        return motherLastName;
    }
    
    public void setFamilyIncome(long familyIncome) {
        this.familyIncome = familyIncome;
    }

    public long getFamilyIncome() {
        return familyIncome;
    }
    
    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }
    
    public String getDateOfAdmission() {
        return dateOfAdmission;
    }
    
    public void setAdmissionCategory(String admissionCategory) {
        this.admissionCategory = admissionCategory;
    }
    
    public String getAdmissionCategory() {
        return admissionCategory;
    }
    
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Standard getStandard() {
        return standard;
    }
    
    public Student () {
    }    
}
