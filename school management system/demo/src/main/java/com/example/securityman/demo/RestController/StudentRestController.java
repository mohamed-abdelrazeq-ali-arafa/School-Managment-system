package com.example.securityman.demo.RestController;

import com.example.securityman.demo.entity.Course;
import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.entity.Student;
import com.example.securityman.demo.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/student")

public class StudentRestController {

     @Autowired
     private IStudentService studentService;
    @RequestMapping(value= "/addstudent",method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);

    }

    @RequestMapping(value= "/registercourse/{studentid}/{courseid}",method = RequestMethod.PUT)
    public Student registerCourse(@PathVariable int studentid,@PathVariable int courseid){
         return studentService.registerStudentForCourse(studentid,courseid);
    }

    @RequestMapping(value= "/countstudent",method = RequestMethod.GET)
    public int  countstudent(){
        return studentService.count();

    }

    @RequestMapping(value="/getstudent/{theid}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int theid){
        Student res = studentService.getStudentById(theid);
        return res;
    }

    @RequestMapping(value="/getallstudent",method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> res = studentService.getAllStudent();
        return res;
    }
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }

    @GetMapping("/getcourses/{studentId}")
    public Set<Course> getCoursesForStudent(@PathVariable int studentId) {
        return studentService.getCoursesForStudent(studentId);
    }

}
