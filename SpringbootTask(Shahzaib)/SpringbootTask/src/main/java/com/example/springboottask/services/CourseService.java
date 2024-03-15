package com.example.springboottask.services;

import com.example.springboottask.dto.CourseDTO;
import com.example.springboottask.entity.Courses;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse (CourseDTO courseDTO);
    List<Courses> readCourses ();
    CourseDTO deleteCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(CourseDTO courseDTO);
}
