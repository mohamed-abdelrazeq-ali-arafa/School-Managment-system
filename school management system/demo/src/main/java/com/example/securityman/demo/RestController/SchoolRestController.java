package com.example.securityman.demo.RestController;

import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.service.ISchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")

public class SchoolRestController {

    @Autowired
    private ISchoolService schoolService;
    public SchoolRestController(ISchoolService schoolService){
        this.schoolService = schoolService;
    }

    @RequestMapping(value= "/addschool",method = RequestMethod.POST)
    public School  addCourse(@RequestBody School school){
        return  schoolService.addSchool(school);
    }

    @RequestMapping(value= "/countschool",method = RequestMethod.GET)
    public int  countschool(){
        return schoolService.count();

    }

    @RequestMapping(value="/getschool/{theid}",method = RequestMethod.GET)
    public School getSchoolById(@PathVariable int theid){
        School res = schoolService.getSchoolById(theid);
        return res;
    }

    @RequestMapping(value="/getallschool",method = RequestMethod.GET)
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }
    @RequestMapping(value="/deleteschool/{id}",method = RequestMethod.DELETE)
    public String deleteSchool(@PathVariable int id){
         return schoolService.deleteSchool(id);
    }

    @PutMapping("updateschool/{id}")
    public String updateSchool(@PathVariable int id, @RequestBody School school) {
          return schoolService.updateSchool(id,school);
    }



}
