package com.example.springboottask.services;

import com.example.springboottask.dto.StudentDTO;
import com.example.springboottask.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<Student> readStudents();

    StudentDTO updateStudent(StudentDTO studentDTO);

    StudentDTO deleteStudent(StudentDTO studentDTO);

    StudentDTO assignCourse (StudentDTO studentDTO);

}
