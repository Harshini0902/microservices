package com.project.MentorOnDemand.Trainings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TrainingServices {
	
	@Autowired
	TrainingRepository trainingRepository;


	public void addTrainings(Trainings trainings, String userName) {
		// TODO Auto-generated method stub
		
		Boolean isThere=false;
		
		String trainName=trainings.getTrainingName();
		String trainStatus=trainings.getTrainingStatus();

		ArrayList<String> trainingsNameList=trainingRepository.findTrainingNames();
		ArrayList<String> trainingStatusList=trainingRepository.findTrainingStatus();

		ArrayList<String> trainersList=trainingRepository.findAllTrainers();
		ArrayList<String> traineesList=trainingRepository.findAllTrainees();

		if(trainingsNameList.isEmpty() && trainingStatusList.isEmpty()) {
			trainingRepository.save(trainings);
			if(trainersList.contains(userName))
				trainingRepository.insertTrainings(userName,1);
			else
				trainingRepository.insertTraineeTrainings(userName,1);
		}else {
		
		for(int i=0;i<trainingsNameList.size();i++) {
			if(trainName.equalsIgnoreCase(trainingsNameList.get(i)) && trainStatus.equalsIgnoreCase(trainingStatusList.get(i))) {
				int trainingNum=trainingRepository.findTrainingNum(trainName,trainStatus);
					//trainingRepository.insertTrainings(userName, trainingNum);
				if(trainersList.contains(userName))
					trainingRepository.insertTrainings(userName,trainingNum);
				else
					trainingRepository.insertTraineeTrainings(userName,trainingNum);

				isThere=true;
				break;
			}else {
				isThere=false;
			}
		}
		
		if(isThere==false) {
			trainingRepository.save(trainings);
			//trainingRepository.insertTrainings(userName,trainingsNameList.size()+1);
			if(trainersList.contains(userName))
				trainingRepository.insertTrainings(userName,trainingsNameList.size()+1);
			else
				trainingRepository.insertTraineeTrainings(userName,trainingsNameList.size()+1);

		}
		
		}
		

		
	}

}
