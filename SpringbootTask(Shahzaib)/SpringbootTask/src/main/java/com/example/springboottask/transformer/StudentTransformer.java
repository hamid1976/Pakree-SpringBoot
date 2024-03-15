package com.example.springboottask.transformer;

import com.example.springboottask.dto.StudentDTO;
import com.example.springboottask.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


@Component
public class StudentTransformer {

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        if (studentDTO.getId() != null) {
            student.setId(Integer.parseInt(studentDTO.getId()));
        }
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNo(studentDTO.getPhoneNo());
        student.setRollNo(studentDTO.getRollNo());
        if (!CollectionUtils.isEmpty(studentDTO.getCourses())) {
            student.setCourses(CourseTransformer.toEntity(studentDTO.getCourses()));
        }

        return student;
    }

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        if (student.getId() != null) {
            studentDTO.setId(student.getId().toString());
        }
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhoneNo(student.getPhoneNo());
        studentDTO.setRollNo(student.getRollNo());
        if (!CollectionUtils.isEmpty(student.getCourses())) {
            studentDTO.setCourses(CourseTransformer.toDTO(student.getCourses()));
        }

        return studentDTO;
    }

    public static Student updateStudent(Student student, StudentDTO studentDTO) {

        if (studentDTO.getFirstName() != null) {
            student.setFirstName(studentDTO.getFirstName());
        }
        if (studentDTO.getLastName() != null) {
            student.setLastName(studentDTO.getLastName());
        }
        if (studentDTO.getEmail() != null) {
            student.setEmail(studentDTO.getEmail());
        }
        if (studentDTO.getPhoneNo() != null) {
            student.setPhoneNo(student.getPhoneNo());
        }
        if (studentDTO.getRollNo() != null) {
            student.setRollNo(studentDTO.getRollNo());
        }
        if (!CollectionUtils.isEmpty(studentDTO.getCourses())) {
            student.setCourses(CourseTransformer.toEntity(studentDTO.getCourses()));

        }

        return student;
    }
}
