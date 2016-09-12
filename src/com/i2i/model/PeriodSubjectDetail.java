package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.Period;
import com.i2i.model.Teacher;
import com.i2i.model.Subject;
import com.i2i.model.Standard;

/**
 * Model class for PeriodSubjectDetail
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */

@Entity
@Table(name= "period_subject_detail")
public class PeriodSubjectDetail {
	
	@Id	
	@GeneratedValue
    @Column(name = "period_subject_id")
	private int periodSubjectId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "period_id")   
	private Period period;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")  
	private Teacher teacher;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")  
	private Subject subject;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "standard_id")  
	private Standard standard;
	
	public void setPeriodSubjectId(int periodSubjectId) {
		this.periodSubjectId = periodSubjectId;
	}
	
	public int getPeriodSubjectId() {
		return periodSubjectId;
	}
	
	public void setPeriod(Period period) {
		this.period = period;		
	}
	
	public Period getPeriod() {
		return period;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;		
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;		
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Standard getStandard() {
		return standard;
	}
}
