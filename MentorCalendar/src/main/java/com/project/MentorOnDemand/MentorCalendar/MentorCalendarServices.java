package com.project.MentorOnDemand.MentorCalendar;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class MentorCalendarServices {


	
	@Autowired
	MentorCalendarRepository mentorCalendarRepository;
	
	public void addCalendar(MentorCalendar mentorCalendar, String userName) {
		// TODO Auto-generated method stub
			
		Boolean isPresent=false;
		
		Date sDate=mentorCalendar.getStartDate();
		Date eDate=mentorCalendar.getEndDate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(sDate);  
		String enDate=dateFormat.format(eDate);
		
		ArrayList<Date> mentorCalendarStartDate=mentorCalendarRepository.findStartDate();
		ArrayList<Date> mentorCalendarEndDate=mentorCalendarRepository.findEndDate();
		
		int calendarNum=0;
		
		if(mentorCalendarStartDate.isEmpty() && mentorCalendarEndDate.isEmpty()) {
			mentorCalendarRepository.save(mentorCalendar);
			//System.out.println("yes");
			mentorCalendarRepository.insertDetails(userName,1);

		}else {
			for(int i=0;i<mentorCalendarStartDate.size();i++) {
				
				String start=dateFormat.format(mentorCalendarStartDate.get(i));
				String end=dateFormat.format(mentorCalendarEndDate.get(i));
				
				if(start.equals(strDate) && end.equals(enDate)) {
					isPresent =true;
					calendarNum=i+1;
					mentorCalendarRepository.insertDetails(userName, calendarNum);
					break;
				}
				else {
					isPresent=false;
				}
			}
			
			if(isPresent==false) {
				calendarNum=mentorCalendarStartDate.size()+1;
				mentorCalendarRepository.save(mentorCalendar);
				mentorCalendarRepository.insertDetails(userName,calendarNum);

			}

		}
	}
	
}
