package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "parent")
public class Parent {
	
	@Id	
    @Column(name = "parent_id")
	private String parentId;
	
	@Column(name = "father_first_name")
	private String fatherFirstName;
	
	@Column(name = "father_last_name")
	private String fatherLastName;
	
	@Column(name = "mother_first_name")
	private String motherFirstName;
	
	@Column(name = "mother_last_name")
	private String motherLastName;
	
	public Parent() {
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getFatherFirstName() {
		return fatherFirstName;
	}
	
	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}
	public String getFatherLastName() {
		return fatherLastName;
	}
	
	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getMotherFirstName() {
		return motherFirstName;
	}
	
	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	
	public String getMotherLastName() {
		return motherLastName;
	}
	
	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}	
	
	public Parent(String fatherFirstName, String fatherLastName, String motherFirstName, String motherLastName) {
		this.fatherFirstName = fatherFirstName;
		this.fatherLastName = fatherLastName;
		this.motherFirstName = motherFirstName;
		this.motherLastName = motherLastName;		
	}
}
