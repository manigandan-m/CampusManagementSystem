package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.Teacher;
import com.i2i.model.Standard;

/**
 * Model class for Subject
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */

@Entity
@Table(name= "subject")
public class Subject {
	@Id	
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)	
	@JoinColumn(name = "teacher_id")
	Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name = "standard_id")
	Standard standard;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

}
