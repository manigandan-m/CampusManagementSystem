package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.User;

@Entity
@Table(name= "teacher")
public class Teacher {
	@Id
    @Column(name = "teacher_id")
	int teacherId;
	
	@Column(name = "years_of_experience")
	int yearsOfExperience;
	
	@Column(name = "months_of_experience")
	int monthsOfExperience;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")    
    private User user;
	
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
