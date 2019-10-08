package com.project.MentorOnDemand.MentorDetails;



import javax.persistence.*;

@Entity
@Table(name="MentorDetails")
public class MentorDetails {

	@Id @Column(unique = true)
	private String userName;	//email
	private String courseName;
	private Double fees;
	private Double commission;
	private String isBlocked;
	private Double totalFees;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}
	public String getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}

	
//@ManyToMany(cascade = CascadeType.ALL)
//private Collection<Trainings> trainings;
//
//public Collection<Trainings> getTrainings() {
//	return trainings;
//}
//public void setTrainings(Collection<Trainings> trainings) {
//	this.trainings = trainings;
//}



	public MentorDetails() {

	}
	
	
}
