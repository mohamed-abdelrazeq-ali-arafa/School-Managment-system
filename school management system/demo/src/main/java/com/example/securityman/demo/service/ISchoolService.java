package com.example.securityman.demo.service;

import com.example.securityman.demo.entity.School;

import java.util.List;

public interface ISchoolService {

    public School addSchool(School school);
    public String deleteSchool(Long id);
    public List<School> getAllSchool();
    public School getSchoolById(Long id);
    public String updateSchool(Long id,School school);
    public boolean existsById(Long id);
    public  int  count();
}
