package com.project.MentorOnDemand.Trainees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TraineesService {

	@Autowired
	TraineeRepository traineeRepository;
	public void addTrainee(TraineesDetails traineesDetails) {
		// TODO Auto-generated method stub
		traineesDetails.setFeesStatus("Paid");
		traineeRepository.save(traineesDetails);
		
		
		
	}

}
