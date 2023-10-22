package com.example.securityman.demo.service;


import com.example.securityman.demo.Response;
import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.entity.Student;

import java.util.List;

public interface IStudentService {


    public Student addStudent(Student student);
    public String deleteStudent(Long id);
    public List<Student> getAllStudent();
    public Student getStudentById(Long id);
     public String updateStudent(Long id,Student student);
    public boolean existsById(Long id);
    public  int  count();

}
