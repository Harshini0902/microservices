package com.project.MentorOnDemand.Trainees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraineeController {

    @Autowired
    private TraineesService traineesService;

    @RequestMapping(method= RequestMethod.POST,value="/addTrainee")
    public void addTrainee(@RequestBody TraineesDetails traineesDetails) {
        traineesService.addTrainee(traineesDetails);
    }
}
