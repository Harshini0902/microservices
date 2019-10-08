package com.project.MentorOnDemand.MentorSkills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MentorSkillsController {

    @Autowired
    MentorSkillsServices mentorSkillsServices;

    @RequestMapping(method = RequestMethod.POST,value="/addSkill/{userName}")
    public void addCalendar(@RequestBody MentorSkills mentorSkills, @PathVariable String userName) {
        mentorSkillsServices.addSkills(mentorSkills,userName);
    }
}
