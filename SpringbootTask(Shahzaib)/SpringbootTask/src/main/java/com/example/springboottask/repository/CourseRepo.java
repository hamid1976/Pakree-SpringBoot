package com.example.springboottask.repository;

import com.example.springboottask.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Integer> {
}
