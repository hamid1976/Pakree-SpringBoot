package com.example.springboottask.servicesimpl;

import com.example.springboottask.dto.StudentDTO;
import com.example.springboottask.entity.Courses;
import com.example.springboottask.entity.Student;
import com.example.springboottask.exception.ResourseNotFoundException;
import com.example.springboottask.repository.CourseRepo;
import com.example.springboottask.repository.StudentRepo;
import com.example.springboottask.services.StudentService;
import com.example.springboottask.transformer.CourseTransformer;
import com.example.springboottask.transformer.StudentTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo  studentRepo;
    private final CourseRepo courseRepo;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        if(ObjectUtils.isEmpty(studentDTO)){
            throw new RuntimeException("Student Can not be Empty!");
        }
        Student student = StudentTransformer.toEntity(studentDTO);

        List<Courses> list= new ArrayList<>();
        for(Courses courses: CourseTransformer.toEntity(studentDTO.getCourses())){
            list.add(courseRepo.findById(courses.getId()).orElseThrow(()-> new ResourseNotFoundException("Course not found with this ID:"+courses.getId())));

        }
        student.setCourses(list);
        return StudentTransformer.toDTO(studentRepo.save(student));
    }

    @Override
    public List<Student> readStudents() {
        return studentRepo.findAll();
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {

        if(studentDTO.getId()==null){
            throw new NullPointerException("Enter ID to update record");
        }
        Student student = studentRepo.findById(Integer.parseInt(studentDTO.getId())).orElseThrow(() -> new ResourseNotFoundException("Student not found with this ID:"+studentDTO.getId()));

        return StudentTransformer.toDTO(studentRepo.save(StudentTransformer.updateStudent(student,studentDTO)));
    }
    @Override
    public StudentDTO deleteStudent(StudentDTO studentDTO) {
        if(studentDTO.getId()==null){
            throw new NullPointerException("Enter ID to delete record");
        }
        Student student = studentRepo.findById(Integer.parseInt(studentDTO.getId())).orElseThrow(() -> new ResourseNotFoundException("Student not found with this ID:"+studentDTO.getId()));
        //studentRepo.deleteById(student.getId());
        StudentDTO dto = StudentTransformer.toDTO(student);
        studentRepo.delete(student);
        return dto;
    }

    @Override
    public StudentDTO assignCourse(StudentDTO studentDTO) {
        if(studentDTO.getId()==null){
            throw new NullPointerException("Enter ID to  Assign Courses!");
        }
        Student student = studentRepo.findById(Integer.parseInt(studentDTO.getId())).orElseThrow(() -> new ResourseNotFoundException("Student not found with this ID:"+studentDTO.getId()));

        List<Courses> list= new ArrayList<>();
        for(Courses courses: CourseTransformer.toEntity(studentDTO.getCourses())){
             list.add(courseRepo.findById(courses.getId()).orElseThrow(()-> new ResourseNotFoundException("Course not found with this ID:"+courses.getId())));

        }
        student.setCourses(list);
        //studentDTO.setCourses(list);
        //student = StudentTransformer.updateStudent(student,studentDTO);
        //student = studentRepo.save(student);
        return StudentTransformer.toDTO(studentRepo.save(StudentTransformer.updateStudent(student,studentDTO)));
    }


}
