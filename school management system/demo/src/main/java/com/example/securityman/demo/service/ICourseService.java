package com.example.securityman.demo.service;

import com.example.securityman.demo.entity.Course;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface ICourseService {

    public Course addCourse(Course course);
    public String deleteCourse(int id);
    public List<Course> getAllCourse();
    public Course getCourseById(int id);
    public String updateCourse(int id,Course school);

}
