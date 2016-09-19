package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;

import com.i2i.model.Role;
import com.i2i.model.Address;

/**
 * Model class for Role
 * Setter and Getter methods for the class variables
 * 
 * @author Zeeshan
 * 
 * @created 2015-09-10
 */

@Entity
@Table(name= "user")
public class User {
   
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
   
    @Column(name = "username")
    private String username;
   
    @Column(name = "password")
    private String password;
   
    @Column(name = "first_name")
    private String firstName;
   
    @Column(name = "last_name")
    private String lastName;
   
    @Column(name = "date_of_birth")
    private String dateOfBirth;
   
    @Column(name = "gender")
    private String gender;
   
    @Column(name = "blood_group")
    private String bloodGroup;
   
    @Column(name = "mobile_number")
    private long mobileNumber;
   
    @Column(name = "nationality")
    private String nationality;
   
    @Column(name = "religion")
    private String religion;
   
    @OneToOne(mappedBy = "user")
    private Address address;
    
    @OneToOne(mappedBy = "user")
    private Teacher teacher;
    
    @OneToOne(mappedBy = "user")
    private Student student;
   
    @ManyToOne(cascade = CascadeType.PERSIST)   
    @JoinColumn(name = "role_id")  
    @LazyCollection(LazyCollectionOption.FALSE)
    private Role role;   

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }
   
    public void setAddress(Address address) {
        this.address = address;
    }
   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
   
    public String getDateOfBirth() {
        return dateOfBirth;
    }   
   
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
   
    public String getNationality() {
        return nationality;
    }
   
    public void setReligion(String religion) {
        this.religion = religion;
    }
   
    public String getReligion() {
        return religion;
    }
   
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;       
    }
   
    public Teacher getTeacher() {
        return teacher;       
    }

    public void setStudent(Student student) {
        this.student = student;       
    }
   
    public Student getStudent() {
        return student;       
    }
   
    public User() {
       
    }
}