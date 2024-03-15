package com.example.springboottask.controller;

import com.example.springboottask.dto.StudentDTO;
import com.example.springboottask.response.ResponseUtil;
import com.example.springboottask.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/student", method={RequestMethod.GET, RequestMethod.DELETE,RequestMethod.PUT, RequestMethod.POST})
public class StudentController {
    private final StudentService studentService;

    @PostMapping ("/createStudent")
    public ResponseEntity<Object> createStudent(@RequestBody StudentDTO studentDTO){
        System.out.println(studentDTO.toString());
        return ResponseUtil.returnResponse(studentService.createStudent(studentDTO));
    }

    @GetMapping("/readStudents")
    public ResponseEntity<Object> readStudents(){

        return ResponseUtil.returnResponse(studentService.readStudents());
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDTO studentDTO){

        return ResponseUtil.returnResponse(studentService.updateStudent(studentDTO));
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Object> deleteStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO dto = studentService.deleteStudent(studentDTO);
        return ResponseUtil.returnResponse(dto);
    }
    @PutMapping("/assignCourses")
    public ResponseEntity<Object> assignCourses(@RequestBody StudentDTO studentDTO){

        return ResponseUtil.returnResponse(studentService.assignCourse(studentDTO));
    }
}
