package com.project.MentorOnDemand.MentorCalendar;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="mentorCalendar")
public class MentorCalendar {
	

	@Id @GeneratedValue(strategy = GenerationType.TABLE) 
	private Integer calendarNum;
	public Integer getNum() {
		return calendarNum;
	}
	public void setNum(Integer num) {
		this.calendarNum = num;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	private Date startDate;
	private Date endDate;


	
}
