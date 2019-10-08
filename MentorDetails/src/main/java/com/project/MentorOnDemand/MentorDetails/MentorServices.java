package com.project.MentorOnDemand.MentorDetails;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
public class MentorServices {

	@Autowired
	private MentorDetailsRepository mentorDetailsRepository;

	public List<MentorDetails> getMentorDetails() {
		List<MentorDetails> mentorsList=new ArrayList<>();
		mentorDetailsRepository.findAll().forEach(mentorsList::add);
		return mentorsList;
	}


	public void addMentor(MentorDetails mentorDetails) {
		// TODO Auto-generated method stub
		Double commission=mentorDetails.getFees()*(0.278);
		 BigDecimal bd = new BigDecimal(commission).setScale(2, RoundingMode.HALF_UP);
	        double comm = bd.doubleValue();
		mentorDetails.setIsBlocked("No");
		mentorDetails.setCommission(comm);
		mentorDetails.setTotalFees(comm+mentorDetails.getFees());
		Boolean isPresent=false;
		ArrayList<String> userNameList= mentorDetailsRepository.findAllUserNames();
		if(userNameList.isEmpty()){
			mentorDetailsRepository.save(mentorDetails);
		}else {
			for (int i = 0; i < userNameList.size(); i++) {
				if (userNameList.contains(mentorDetails.getUserName())) {
					isPresent = true;
					throw new DataIntegrityViolationException("already exists");
					//break;
				} else {
					isPresent = false;
				}
			}
			if (isPresent == false) {
				mentorDetailsRepository.save(mentorDetails);
			}
		}
	}


	public MentorDetails getMentor(String userName) {
		MentorDetails mentorDetails=mentorDetailsRepository.findById(userName).get();
		return mentorDetails;
	}

	public void addCalendar(MentorCalendar mentorCalendar, String userName) {
		MentorDetails mentorDetails=new MentorDetails();
		mentorDetails=mentorDetailsRepository.findById(userName).get();
		List<MentorDetails>mentorDetailsList=new ArrayList<MentorDetails>();
		mentorDetailsList.add(mentorDetails);
		mentorCalendar.setMenDetailsList(mentorDetailsList);
	}
}
