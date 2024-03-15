package com.example.springboottask.servicesimpl;

import com.example.springboottask.dto.CourseDTO;
import com.example.springboottask.entity.Courses;
import com.example.springboottask.exception.ResourseNotFoundException;
import com.example.springboottask.repository.CourseRepo;
import com.example.springboottask.services.CourseService;
import com.example.springboottask.transformer.CourseTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        if(ObjectUtils.isEmpty(courseDTO)){
            throw new RuntimeException("Student Can not be Empty!");
        }

        Courses courses = CourseTransformer.toEntity(courseDTO);
        return CourseTransformer.toDTO(courseRepo.save(courses));
    }

    @Override
    public List<Courses> readCourses() {
        List<Courses> list = courseRepo.findAll();
        return list;
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        if(courseDTO.getId()==null){
            throw new NullPointerException("Enter ID to update record");
        }
        Courses courses = courseRepo.findById(Integer.parseInt(courseDTO.getId())).orElseThrow(()-> new ResourseNotFoundException("Course not found with this ID:"+courseDTO.getId()));
        courses = CourseTransformer.updateCourse(courses,courseDTO);
        return CourseTransformer.toDTO(courseRepo.save(courses));

    }

    @Override
    public CourseDTO deleteCourse(CourseDTO courseDTO) {
        if(courseDTO.getId()==null){
            throw new NullPointerException("Enter ID to update record");
        }
        Courses courses = courseRepo.findById(Integer.parseInt(courseDTO.getId())).orElseThrow(()-> new ResourseNotFoundException("Course not found with this ID:"+courseDTO.getId()));
        courseRepo.deleteById(courses.getId());

        return CourseTransformer.toDTO(courses);
    }
}
