package com.eTEKCoding.springBoot.springBootLearn.courseController.entity;

import javax.persistence.*;

// Magic of spring boot auto configuration
// If we don't want the default field names in the table, you can customize it here
// @Entity(name="course_table")
//     @Column(name="course_name") for
//    private String course;
@Entity(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Course() {
    }
}
