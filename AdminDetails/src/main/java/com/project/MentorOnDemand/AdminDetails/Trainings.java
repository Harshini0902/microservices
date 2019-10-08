package com.project.MentorOnDemand.AdminDetails;

import javax.persistence.*;
import java.util.Collection;


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
		
//		@ManyToMany(mappedBy = "trainings")
//		private Collection<MentorDetails> mentorDetails;
//		public Collection<MentorDetails> getMentorDetails() {
//			return mentorDetails;
//		}
//		public void setMentorDetails(Collection<MentorDetails> mentorDetails) {
//			this.mentorDetails = mentorDetails;
//		}
}
