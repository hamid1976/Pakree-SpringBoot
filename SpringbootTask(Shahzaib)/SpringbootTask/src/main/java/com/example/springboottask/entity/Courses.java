package com.example.springboottask.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(name = "course_title")
    private String courseTitle;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinTable(name = "student_courses",
            joinColumns = { @JoinColumn(name = "courses_course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    @JsonBackReference
    private List<Student> studentsList;
}
