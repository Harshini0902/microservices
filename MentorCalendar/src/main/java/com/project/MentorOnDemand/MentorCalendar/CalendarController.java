package com.project.MentorOnDemand.MentorCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalendarController {
    @Autowired
    MentorCalendarServices mentorCalendarServices;


    @RequestMapping(method = RequestMethod.POST,value="/addMentor/addCalendar/{userName}")
    public void addCalendar(@RequestBody MentorCalendar mentorCalendar,@PathVariable String userName) {
        mentorCalendarServices.addCalendar(mentorCalendar,userName);
    }
}
