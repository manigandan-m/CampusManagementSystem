package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.Teacher;

@Entity
@Table(name= "standard")
public class Standard {
	@Id
	@Column(name = "standard_id")
	private int standardId;
	
	@Column(name = "standard_name")
	private String standardName;
	
	@Column(name = "section_name")
	private String sectionName;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")
	private Teacher classCoordinator;

	public int getStandardId() {
		return standardId;
	}

	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Teacher getClassCoordinator() {
		return classCoordinator;
	}

	public void setClassCoordinator(Teacher classCoordinator) {
		this.classCoordinator = classCoordinator;
	}
	
	public Standard() { 
	}

}
