package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "period")
public class Period {
	
	@Id	
    @Column(name = "period_id")
	private int periodId;
	
	@Column(name = "day_of_period")
	private String dayOfPeriod;
	
	@Column(name = "time_of_period")
	private String timeOfPeriod;
	
	public Period() {
	}
	
	public int getPeriodId() {
		return periodId;
	}
	
	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}
	
	public String getDay() {
		return dayOfPeriod;
	}
	
	public void setDay(String dayOfPeriod) {
		this.dayOfPeriod = dayOfPeriod;
	}
	
	public String getTime() {
		return timeOfPeriod;
	}
	
	public void setTime(String timeOfPeriod) {
		this.timeOfPeriod = timeOfPeriod;
	}
	
	public String toString() {
	    return ("Period ID:" + periodId + "Day:" + dayOfPeriod + "Time:" + timeOfPeriod);	
	}
}
