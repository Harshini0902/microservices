package com.project.MentorOnDemand.AdminDetails;

import javax.persistence.*;

public class MentorSkills {

	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int skillId;
	private String skillName;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "mentor_name")
//	private MentorDetails mentorDetails;
//
//	public MentorDetails getMentorDetails() {
//		return mentorDetails;
//	}
//	public void setMentorDetails(MentorDetails mentorDetails) {
//		this.mentorDetails = mentorDetails;
//	}
	
	
	
	
}
