package com.project.MentorOnDemand.MentorDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MentorDetailsController {
    @Autowired
    MentorServices mentorServices;

    @RequestMapping("/mentorsList")
    public MentorServices getMentorDetails() {
        return mentorServices;
    }

    @RequestMapping(value="/getMentor/{userName}")
    public MentorDetails getMentor(@PathVariable(value="userName") String userName){
        MentorDetails mentorDetails=mentorServices.getMentor(userName);
        return mentorDetails;
    }
    @RequestMapping(method = RequestMethod.POST,value="/addMentor")
    public void addMentor(@RequestBody MentorDetails mentorDetails) {
        mentorServices.addMentor(mentorDetails);
       // mentorServices.addCalendar();
    }




}
