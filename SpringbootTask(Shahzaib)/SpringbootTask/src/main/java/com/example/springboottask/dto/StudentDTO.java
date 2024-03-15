package com.example.springboottask.dto;

import com.example.springboottask.entity.Courses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String rollNo;
    private List<CourseDTO> courses;
}
