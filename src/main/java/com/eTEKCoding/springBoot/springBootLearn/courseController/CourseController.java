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

  // Retrieve
  @RequestMapping(method = RequestMethod.GET, path = "/courses")
    public List<Course> retrieveAllCourses(){
    return repository.findAll();
//      Course course = new Course(2, "Spring Data JPA 33", "TEKCoding");
//       return Arrays.asList(course);
  }

  // Retrieve
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

  // Add
  @RequestMapping(method = RequestMethod.POST, path = "/courses")
  public String addCourse(@RequestBody Course course) {
   repository.save(course);
   return course.getCourse() + " saved successfully";
  }

  // Update
  @RequestMapping(method = RequestMethod.PUT, path = "/courses/{id}")
  public Course updateCourse( @PathVariable Integer id, @RequestBody Course course){
    return repository.save(course);
  }

  // Delete
  @RequestMapping(method = RequestMethod.DELETE, path = "/courses/{id}")
  public String deleteCourse( @PathVariable int id){
    if(new Course().getId() != id){
      return "The course with " + id + "does not exists";
    }else {
      repository.deleteById(id);
      return id + " removed";
    }
  }
}
