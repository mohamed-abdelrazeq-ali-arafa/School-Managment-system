package com.example.securityman.demo.implService;

import com.example.securityman.demo.entity.Course;
import com.example.securityman.demo.repository.ICourseRepository;
import com.example.securityman.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;


    @Override
    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public String deleteCourse(int id) {
        Course temp=courseRepository.findById(id).orElse(null);
        if(temp==null)
            return "There is No Course with his id";
        return "Success delete of course";

    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
       return courseRepository.findById(id).orElse(null);
    }

    @Override
    public String updateCourse(int id, Course course) {
        Course temp=courseRepository.findById(id).orElse(null);
        if(temp==null)
            return "There is No course with this id";
        temp.setName(course.getName());
        temp.setCode(course.getCode());
        temp.setDepartment(course.getDepartment());
        temp.setCreditHours(course.getCreditHours());
        temp.setCode(course.getCode());
        return "Success update";
    }




}
