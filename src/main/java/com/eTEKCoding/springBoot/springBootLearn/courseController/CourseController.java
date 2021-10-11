package com.eTEKCoding.springBoot.springBootLearn.courseController;

import com.eTEKCoding.springBoot.springBootLearn.courseController.entity.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

  //localhost:8080/courses

  @RequestMapping(method = RequestMethod.GET, path = "/courses")
    public List<Course> retrieveAllCourses(){
      Course course = new Course(2, "Spring Data JPA", "TEKCoding55");
       return Arrays.asList(course);
  }

  // localhost:8080/courses/1
  @RequestMapping(method = RequestMethod.GET, path = "courses/1")
    public Course retrieveCourseById() {
      Course course = new Course(1, "Spring Boot", "TEKCoding");
          return course;
  }
}
