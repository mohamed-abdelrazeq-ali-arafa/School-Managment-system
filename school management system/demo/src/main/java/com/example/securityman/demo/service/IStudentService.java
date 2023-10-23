package com.example.securityman.demo.service;


import com.example.securityman.demo.entity.Course;
import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface IStudentService {


    public Student addStudent(Student student);
    public String deleteStudent(int id);
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
     public String updateStudent(int id,Student student);
    public boolean existsById(int id);
    public Student registerStudentForCourse(int studentId, int courseId);
    Set<Course> getCoursesForStudent(int studentId);
    public  int  count();

}
