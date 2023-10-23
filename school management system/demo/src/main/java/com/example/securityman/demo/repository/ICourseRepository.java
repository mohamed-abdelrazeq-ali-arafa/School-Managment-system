package com.example.securityman.demo.repository;

import com.example.securityman.demo.entity.Course;
import com.example.securityman.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {

}
