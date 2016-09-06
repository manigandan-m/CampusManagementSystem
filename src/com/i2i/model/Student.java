package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.User;
import com.i2i.model.Standard;

@Entity
@Table(name= "student")
public class Student {
	
	@Id
	@Column(name = "roll_number")
	private int rollNumber;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")   
	private User user;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;

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
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "religion")
	private String religion;
	
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
	
	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Standard getStandard() {
		return standard;
	}
	
	public Student () {
	}	
	
	public Student(User user, String dateOfBirth, String fatherFirstName, String fatherLastName, String motherFirstName, String motherLastName, long familyIncome, String nationality, String religion, Standard standard) {	        
	    this.user = user;
		this.dateOfBirth = dateOfBirth;
	    this.fatherFirstName = fatherFirstName;
	    this.fatherLastName = fatherLastName; 
	    this.motherFirstName = motherFirstName;
	    this.motherLastName = motherLastName; 
	    this.familyIncome = familyIncome; 
	    this.nationality = nationality;
		this.religion = religion;
		this.standard = standard;
	}
	
}
