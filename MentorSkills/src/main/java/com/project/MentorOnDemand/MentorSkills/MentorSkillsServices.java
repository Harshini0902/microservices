package com.project.MentorOnDemand.MentorSkills;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MentorSkillsServices {

	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	

	
	public void addSkills(MentorSkills mentorSkills,String userName) {

		//MentorDetails mentorDetails=new MentorDetails();
		System.out.println("details="+userName);
		//MentorDetails mentorDetails=mentorSkillsRepository.findMentorDetails(userName);
		//mentorSkills.setMentorDetails(mentorDetails);

		mentorSkillsRepository.save(mentorSkills);
		int skillId=mentorSkills.getSkillId();
		System.out.println("id="+skillId);
		mentorSkillsRepository.updateMentorName(userName,skillId);

		
		

	}

	

	
}
