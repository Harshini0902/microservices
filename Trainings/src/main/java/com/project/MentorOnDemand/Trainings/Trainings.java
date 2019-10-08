package com.project.MentorOnDemand.Trainings;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainings")
public class Trainings {

		@Id @GeneratedValue(strategy = GenerationType.TABLE) 
		Integer trainingNum;
		String trainingName;
		String trainingStatus;
		public Integer getTrainingNum() {
			return trainingNum;
		}
		public void setTrainingNum(Integer trainingNum) {
			this.trainingNum = trainingNum;
		}
		public String getTrainingName() {
			return trainingName;
		}
		public void setTrainingName(String trainingName) {
			this.trainingName = trainingName;
		}
		public String getTrainingStatus() {
			return trainingStatus;
		}
		public void setTrainingStatus(String trainingStatus) {
			this.trainingStatus = trainingStatus;
		}
		
		@ManyToMany(mappedBy = "trainings")
		private Collection<MentorDetails> mentorDetails;
		public Collection<MentorDetails> getMentorDetails() {
			return mentorDetails;
		}
		public void setMentorDetails(Collection<MentorDetails> mentorDetails) {
			this.mentorDetails = mentorDetails;
		}

		@ManyToMany(mappedBy = "traineeTrainings")
		private Collection<TraineesDetails> traineesDetails;

	public Collection<TraineesDetails> getTraineesDetails() {
		return traineesDetails;
	}

	public void setTraineesDetails(Collection<TraineesDetails> traineesDetails) {
		this.traineesDetails = traineesDetails;
	}
}
