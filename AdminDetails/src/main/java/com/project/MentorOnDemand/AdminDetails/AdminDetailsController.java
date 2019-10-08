package com.project.MentorOnDemand.AdminDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdminDetailsController {
    @Autowired
    AdminDetailsService adminDetailsService;

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/adminCourses")
    public AdminDetailsService getAdminCourses() {
        return adminDetailsService;
    }

    @PostMapping("/addMentor")
    public void addMentor(@RequestBody MentorDetails mentorDetails) {
        System.out.println("helllo");
        MentorDetails  mentDetails=restTemplate.postForObject("http://localhost:9096/addMentor",mentorDetails,MentorDetails.class);

        adminDetailsService.addCourse(mentorDetails);
    }

    @PostMapping("/addCalendar/{userName}")
    public void addCalendar(@RequestBody MentorCalendar mentorCalendar,@PathVariable (value="userName") String userName) throws Exception {
        adminDetailsService.checkForUser(userName);
        MentorCalendar mentCalendar=restTemplate.postForObject("http://localhost:9097/addMentor/addCalendar/"+userName,mentorCalendar,MentorCalendar.class);
    }

    @PostMapping("/addSkill/{userName}")
    public void addSkill(@RequestBody MentorSkills mentorSkill,@PathVariable(value="userName") String userName) throws Exception {
        System.out.println("name="+userName);
        adminDetailsService.checkForUser(userName);
        restTemplate.postForObject("http://localhost:9098/addSkill/"+userName,mentorSkill,MentorSkills.class);
    }

    @PostMapping("/addTraining/{userName}")
    public void addTraining(@RequestBody Trainings trainings,@PathVariable(value = "userName") String userName) throws Exception {
        adminDetailsService.checkForUser(userName);
        restTemplate.postForObject("http://localhost:9099/addTrainings/"+userName,trainings,Trainings.class);
    }

    @PostMapping("/addTrainee")
    public void addTrainee(@RequestBody TraineesDetails traineesDetails){
        restTemplate.postForObject("http://localhost:9100/addTrainee",traineesDetails,TraineesDetails.class);
    }


}
