package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/**
 * Model class for Period
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 */

@Entity
@Table(name= "period")
public class Period {
	
	@Id
    @GeneratedValue	
    @Column(name = "period_id")
	private int periodId;
	
	@Column(name = "day_of_period")
	private String dayOfPeriod;
	
	@Column(name = "start_time_of_period")
	private String startTimeOfPeriod;
	
	@Column(name = "end_time_of_period")
	private String endTimeOfPeriod;
	
	public Period() {
	}
	
	public int getPeriodId() {
		return periodId;
	}
	
	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}
	
	public String getDayOfPeriod() {
		return dayOfPeriod;
	}
	
	public void setDayOfPeriod(String dayOfPeriod) {
		this.dayOfPeriod = dayOfPeriod;
	}
	
	public String getStartTimeOfPeriod() {
		return startTimeOfPeriod;
	}
	
	public void setStartTimeOfPeriod(String startTimeOfPeriod) {
		this.startTimeOfPeriod = startTimeOfPeriod;
	}
	
	public String getEndTimeOfPeriod() {
		return endTimeOfPeriod;
	}
	
	public void setEndTimeOfPeriod(String endTimeOfPeriod) {
		this.endTimeOfPeriod = endTimeOfPeriod;
	}
	
	public String toString() {
	    return ("Period ID:" + periodId + "Day:" + dayOfPeriod + "Start Time:" + startTimeOfPeriod + "End Time:" + endTimeOfPeriod);	
	}
}