package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.User;
import com.i2i.model.Parent;
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

	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")  
	private Parent parent;
	
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
	
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	public String getReligion() {
		return religion;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Parent getParent() {
		return parent;
	}
	
	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Standard getStandard() {
		return standard;
	}
	
	public Student () {
	}	
	
	public Student(User user, String dateOfBirth, Parent parent, String nationality, String religion, Standard standard) {	        
	    this.user = user;
		this.dateOfBirth = dateOfBirth;
	    this.parent = parent;
	    this.nationality = nationality;
		this.religion = religion;
		this.standard = standard;
	}
	
}
