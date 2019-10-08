package com.project.MentorOnDemand.MentorCalendar;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface MentorCalendarRepository extends CrudRepository<MentorCalendar, Integer>{

	
	@Query(value="SELECT startDate FROM MentorCalendar")
	ArrayList<Date> findStartDate();
	
	@Query(value="SELECT endDate FROM MentorCalendar")
	ArrayList<Date> findEndDate();

	@Modifying
    @Transactional
    @Query(value="UPDATE MentorDetailsDatabase.mentor_details SET calendar_num=?2 WHERE user_name=?1",nativeQuery = true)
    void insertDetails(String userName, int calendarNum);
	

}
