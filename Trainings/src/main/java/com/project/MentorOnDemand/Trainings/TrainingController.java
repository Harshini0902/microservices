package com.project.MentorOnDemand.Trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainingController {
    @Autowired
    TrainingServices trainingServices;

    @RequestMapping(method = RequestMethod.POST,value="/addTrainings/{userName}")
    public void addCalendar(@RequestBody Trainings trainings, @PathVariable String userName) {
        trainingServices.addTrainings(trainings,userName);
    }
}
