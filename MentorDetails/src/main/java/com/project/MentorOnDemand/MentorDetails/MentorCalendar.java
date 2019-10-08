package com.project.MentorOnDemand.MentorDetails;

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


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="calendarNum")
	private List<MentorDetails> menDetailsList;
	public List<MentorDetails> getMenDetailsList() {
		return menDetailsList;
	}
	public void setMenDetailsList(List<MentorDetails> menDetailsList) {
		this.menDetailsList = menDetailsList;
	}
	
}
