package com.eTEKCoding.springBoot.springBootLearn.courseController;

import com.eTEKCoding.springBoot.springBootLearn.courseController.entity.Course;
import com.eTEKCoding.springBoot.springBootLearn.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

  @Autowired
  private CourseRepository repository;
  //localhost:8080/courses

  @RequestMapping(method = RequestMethod.GET, path = "/courses")
    public List<Course> retrieveAllCourses(){
    return repository.findAll();
//      Course course = new Course(2, "Spring Data JPA 33", "TEKCoding");
//       return Arrays.asList(course);
  }

  // localhost:8080/courses/1
  @RequestMapping(method = RequestMethod.GET, path = "courses/{id}")
    public Course retrieveCourseById(@PathVariable int id) {
    Optional<Course> course = repository.findById(id);

   if(course.isEmpty()){
      throw new RuntimeException("Course not found with id "+ id);
    }else{
    return course.get();
    }

   // return course.orElseThrow(RuntimeException::new);

//      Course course = new Course(1, "Spring Boot Data JPA", "TEKCoding33");
//          return course;
  }

  @RequestMapping(method = RequestMethod.POST, path = "/courses")
  public String addCourse(@RequestBody Course course) {
   repository.save(course);
   return course.getCourse() + " saved successfully";
  }
}
