package com.eTEKCoding.springBoot.springBootLearn.repository;

import com.eTEKCoding.springBoot.springBootLearn.courseController.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
