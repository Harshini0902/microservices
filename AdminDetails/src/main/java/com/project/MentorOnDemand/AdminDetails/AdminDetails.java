package com.project.MentorOnDemand.AdminDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminDetails")
public class AdminDetails {

    @Id
    @GeneratedValue
    private int courseId;
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    private String courseName;

    private int numMentors;
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getNumMentors() {
        return numMentors;
    }
    public void setNumMentors(int numMentors) {
        this.numMentors = numMentors;
    }

    public AdminDetails() {

    }

}