package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.Teacher;

/**
 * Model class for Standard
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Manigandan
 * 
 * @created 2015-08-27
 */

@Entity
@Table(name= "standard")
public class Standard {
	@Id
	@GeneratedValue
	@Column(name = "standard_id")
	private int standardId;
	
	@Column(name = "standard_name")
	private String standardName;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coordinator_id")
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
	
	
	public Teacher getClassCoordinator() {
		return classCoordinator;
	}

	public void setClassCoordinator(Teacher classCoordinator) {
		this.classCoordinator = classCoordinator;
	}
	
	public Standard() { 
	}
	
	public Standard(String standardName) { 
		this.standardName = standardName;
		
	}
	

}
