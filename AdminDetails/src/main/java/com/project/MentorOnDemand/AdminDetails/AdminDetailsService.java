package com.project.MentorOnDemand.AdminDetails;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminDetailsService {
    @Autowired
    private AdminDetailsRepository adminDetailsRepository;


    public List<AdminDetails> getAdminCourses() {
        List<AdminDetails> adminCoursesList=new ArrayList<>();
        adminDetailsRepository.findAll().forEach(adminCoursesList::add);
        return adminCoursesList;
    }

    public void addCourse(MentorDetails mentorDetails)  {
        String cname=mentorDetails.getCourseName();

        String course=adminDetailsRepository.findCourse(mentorDetails.getUserName());
        System.out.println("cname="+course);

        LinkedHashSet<String> coursesAll=adminDetailsRepository.findAllCourses();
        int count=adminDetailsRepository.findCount(cname);
       Boolean isPresent=false;
        AdminDetails adminCourses = new AdminDetails();

        if(coursesAll.isEmpty()) {
            adminCourses.setCourseName(mentorDetails.getCourseName());
            System.out.println(count);
            adminCourses.setNumMentors(count);
            adminDetailsRepository.save(adminCourses);
        }
        else {
            for(String str:coursesAll) {
                if(mentorDetails.getCourseName().equalsIgnoreCase(str)) {
                    System.out.println("hello");
                    System.out.println(count);
                    adminDetailsRepository.updateCount(cname, count);
                    isPresent=false;
                    break;
                }
                else {
                    System.out.println("hiii");
                    isPresent=true;
                }
            }
            if(isPresent==true){
                adminCourses.setCourseName(mentorDetails.getCourseName());
                System.out.println(count);
                adminCourses.setNumMentors(count);
                adminDetailsRepository.save(adminCourses);
            }
        }

    }

    public void checkForUser(String userName) throws Exception {
        String isUser=adminDetailsRepository.checkForUser(userName);
        String isTrainee=adminDetailsRepository.checkForTrainee(userName);
        if(isUser==null && isTrainee==null){
            throw new Exception("USER DOESN'T EXISTS");
        }
    }
}



