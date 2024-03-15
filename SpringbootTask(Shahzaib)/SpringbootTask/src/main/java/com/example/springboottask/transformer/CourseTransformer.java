package com.example.springboottask.transformer;

import com.example.springboottask.dto.CourseDTO;
import com.example.springboottask.entity.Courses;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseTransformer {
    public static Courses toEntity(CourseDTO courseDTO){
        Courses courses = new Courses();
        if(courseDTO.getId()!=null){
            courses.setId(Integer.parseInt(courseDTO.getId()));
        }
        courses.setCourseTitle(courseDTO.getCourseTitle());

        return courses;
    }

    public static CourseDTO toDTO(Courses courses){
        CourseDTO courseDTO = new CourseDTO();
        if(courses.getId()!=null){
            courseDTO.setId(courses.getId().toString());
        }
        courseDTO.setCourseTitle(courses.getCourseTitle());
        return courseDTO;
    }
    public static List<Courses> toEntity(List<CourseDTO> list){
        List<Courses> courses = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (CourseDTO courseDTO : list) {
                courses.add(CourseTransformer.toEntity(courseDTO));
            }
        }
        return courses;
    }

    public static List<CourseDTO> toDTO(List<Courses> list){
        List<CourseDTO> coursesDTO = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (Courses courses : list) {
                coursesDTO.add(CourseTransformer.toDTO(courses));
            }
        }
        return coursesDTO;
    }


    public static Courses updateCourse(Courses courses, CourseDTO courseDTO){
        if(courseDTO.getCourseTitle()!=null){
            courses.setCourseTitle(courseDTO.getCourseTitle());
        }
        return courses;
    }

}
