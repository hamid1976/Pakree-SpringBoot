package com.example.springboottask.controller;


import com.example.springboottask.dto.CourseDTO;
import com.example.springboottask.dto.StudentDTO;
import com.example.springboottask.response.ResponseUtil;
import com.example.springboottask.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/courses", method={RequestMethod.GET, RequestMethod.DELETE,RequestMethod.PUT, RequestMethod.POST})

public class CourseController {
    private final CourseService courseService;

    @PostMapping("/createCourse")
    public ResponseEntity<Object> createCourse(@RequestBody CourseDTO courseDTO){

        return ResponseUtil.returnResponse(courseService.createCourse(courseDTO));
    }

    @GetMapping("/readCourses")
    public ResponseEntity<Object> readCourses(){

        return ResponseUtil.returnResponse(courseService.readCourses());
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<Object> updateCourse(@RequestBody CourseDTO courseDTO){

        return ResponseUtil.returnResponse(courseService.updateCourse(courseDTO));
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<Object> deleteCourse(@RequestBody CourseDTO courseDTO){

        return ResponseUtil.returnResponse(courseService.deleteCourse(courseDTO));
    }
}
