package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import com.i2i.model.Teacher;
import com.i2i.model.Standard;

/**
 * Model class for PeriodSubjectDetail
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Manigandan
 * 
 * @created 2016-09-12
 */

@Entity
@Table(name= "period_subject_detail")
public class PeriodSubjectDetail {
	
    @Id	
    @GeneratedValue
    @Column(name = "period_subject_id")
    private int periodSubjectId;
	
    @Column(name = "period_id") 
    private int periodId;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")  
    private Teacher teacher;	
	
    @Column(name = "subject_code") 
    private String subjectCode;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "standard_id")  
    private Standard standard;
	
    public void setPeriodSubjectId(int periodSubjectId) {
        this.periodSubjectId = periodSubjectId;
    }
	
    public int getPeriodSubjectId() {
        return periodSubjectId;
    }
	
    public void setPeriodId(int periodId) {
        this.periodId = periodId;                                                                                                    
    }
	
    public int getPeriodId() {
        return periodId;
    }
	
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;                                                                                                    
    }
	
    public Teacher getTeacher() {
        return teacher;
    }
	
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;                                                                                                    
    }
	
    public String getSubjectCode() {
        return subjectCode;
    }
	
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Standard getStandard() {
        return standard;
    }
}
