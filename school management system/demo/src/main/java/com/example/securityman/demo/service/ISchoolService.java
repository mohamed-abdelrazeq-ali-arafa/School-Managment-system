package com.example.securityman.demo.service;

import com.example.securityman.demo.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISchoolService {

    public School addSchool(School school);
    public String deleteSchool(int id);
    public List<School> getAllSchool();
    public School getSchoolById(int id);
    public String updateSchool(int id,School school);
    public boolean existsById(int id);
    public  int  count();
}
