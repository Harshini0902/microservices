package com.project.MentorOnDemand.Trainings;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="TraineesDetails")
public class TraineesDetails {

	@Id
	private String userName;
	private String feesStatus;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFeesStatus() {
		return feesStatus;
	}
	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Trainings> getTraineeTrainings() {
		return traineeTrainings;
	}

	public void setTraineeTrainings(Collection<Trainings> traineeTrainings) {
		this.traineeTrainings = traineeTrainings;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Trainings> traineeTrainings;



}
