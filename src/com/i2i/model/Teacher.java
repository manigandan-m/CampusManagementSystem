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

/**
 * Model class for Teacher
 * It is a person who teaches in school 
 * Setter and Getter methods for the class variables
 * 
 * @author Zeeshan
 * 
 * @created 2016-09-07
 */

@Entity
@Table(name= "teacher")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    int teacherId;
    
    @Column(name = "years_of_experience")
    int yearsOfExperience;
    
    @Column(name = "months_of_experience")
    int monthsOfExperience;
    
    @Column(name = "qualification")
    String qualification;
    
    @Column(name = "marital_status")
    String maritalStatus;
    
    @Column(name = "date_of_joining")
    String dateOfJoining;
    
    @Column(name = "designation")
    String designation;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") 
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;    
    
    @OneToOne(mappedBy = "classCoordinator")
    private Standard standardOfCoordinator;
    
    public int getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
    public int getMonthsOfExperience() {
        return monthsOfExperience;
    }
    
    public void setMonthsOfExperience(int monthsOfExperience) {
        this.monthsOfExperience = monthsOfExperience;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    public String getQualification() {
        return qualification;
    }
    
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    public String getMaritalStatus() {
        return maritalStatus;
    }
    
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
        
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public Standard getstandardOfCoordinator() {
        return standardOfCoordinator;
    }
    
    public void setStandardOfCoordinator(Standard standardOfCoordinator) {
        this.standardOfCoordinator = standardOfCoordinator;
    }
        
    public Teacher() {
        
    }
}
