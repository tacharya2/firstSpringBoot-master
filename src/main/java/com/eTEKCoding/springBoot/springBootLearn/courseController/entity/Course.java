package com.eTEKCoding.springBoot.springBootLearn.courseController.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Course {

    private int id;
    private String course;
    private String school;

    public Course(int id, String course, String school) {
        this.id = id;
        this.course = course;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getSchool() {
        return school;
    }
}
