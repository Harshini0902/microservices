package com.project.MentorOnDemand.Trainings;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface TrainingRepository extends CrudRepository<Trainings, Integer>{
	
	@Query(value="SELECT trainingName from Trainings")
	ArrayList<String> findTrainingNames();
	
	@Query(value="SELECT trainingStatus from Trainings")
	ArrayList<String> findTrainingStatus();

	@Modifying
	@Transactional
	@Query(value="INSERT INTO mentor_details_trainings(mentor_details_user_name,trainings_training_num) values (:userName, :trainingNum)",nativeQuery = true)
	void insertTrainings(String userName, Integer trainingNum);

	@Query(value = "SELECT training_num from Trainings WHERE training_name=?1 and training_status=?2",nativeQuery = true)
	int findTrainingNum(String trainingName,String trainingStatus);

	@Query(value="SELECT  mentor_details_user_name from mentor_details_trainings where mentor_details_user_name=?1 and trainings_training_num=?2",nativeQuery = true)
	String findExistence(String userName,int trainingNum);

	@Query(value="SELECT user_name from MentorDetailsDatabase.mentor_details",nativeQuery = true)
	ArrayList<String> findAllTrainers();

	@Query(value="SELECT user_name from TraineeDatabase.trainees_details",nativeQuery = true)
	ArrayList<String> findAllTrainees();

	@Modifying
	@Transactional
	@Query(value="INSERT INTO trainees_details_trainee_trainings( trainees_details_user_name,trainee_trainings_training_num) VALUES(:userName,:trainingNum)",nativeQuery = true)
	void insertTraineeTrainings(String userName,Integer trainingNum);
}
