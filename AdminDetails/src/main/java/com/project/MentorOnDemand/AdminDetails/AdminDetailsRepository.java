package com.project.MentorOnDemand.AdminDetails;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;

public interface AdminDetailsRepository extends CrudRepository<AdminDetails,String> {

    @Query(value="SELECT courseName from AdminDetails")
    LinkedHashSet<String> findAllCourses();

    @Transactional
    @Query(value="select Count(user_name) from MentorDetailsDatabase.mentor_details where course_name=?1",nativeQuery = true)
    int findCount(String cname);

    @Modifying
    @Transactional
    @Query(value="UPDATE admin_details SET num_mentors=?2 WHERE course_name=?1",nativeQuery = true)
    int updateCount(String cname, int count);

    @Transactional
    @Query(value="select course_name from MentorDetailsDatabase.mentor_details where user_name=?1",nativeQuery = true)
    String findCourse(String userName);

    @Transactional
    @Query(value="select user_name from MentorDetailsDatabase.mentor_details where user_name=?1",nativeQuery = true)
    String checkForUser(String userName);

    @Transactional
    @Query(value="Select user_name from TraineeDatabase.trainees_details WHERE user_name=?1",nativeQuery = true)
    String checkForTrainee(String userName);
}
