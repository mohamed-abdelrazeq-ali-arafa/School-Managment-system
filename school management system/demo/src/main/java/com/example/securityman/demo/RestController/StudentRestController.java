package com.example.securityman.demo.RestController;

import com.example.securityman.demo.Response;
import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.entity.Student;
import com.example.securityman.demo.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/student")

public class StudentRestController {

     @Autowired
     private IStudentService studentService;
    @RequestMapping(value= "/addstudent",method = RequestMethod.POST)
    public Student addCourse(@RequestBody Student student){
        studentService.addStudent(student);
        return student;

    }

    @RequestMapping(value= "/countstudent",method = RequestMethod.GET)
    public int  countstudent(){
        return studentService.count();

    }

    @RequestMapping(value="/getstudent/{theid}",method = RequestMethod.GET)
    public Student getCourseById(@PathVariable Long theid){
        Student res = studentService.getStudentById(theid);
        return res;
    }

    @RequestMapping(value="/getallstudent",method = RequestMethod.GET)
    public List<Student> getAllSchool(){
        List<Student> res = studentService.getAllStudent();
        return res;
    }
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.DELETE)
    public String deleteSchool(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }

}
