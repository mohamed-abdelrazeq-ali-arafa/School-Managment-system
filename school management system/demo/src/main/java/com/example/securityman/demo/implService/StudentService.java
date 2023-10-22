package com.example.securityman.demo.implService;

import com.example.securityman.demo.Mappers.SchoolMapper;
import com.example.securityman.demo.Mappers.StudentMapper;
import com.example.securityman.demo.Response;
import com.example.securityman.demo.entity.School;
import com.example.securityman.demo.entity.Student;
import com.example.securityman.demo.repository.ISchoolRepository;
import com.example.securityman.demo.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  implements IStudentService{


    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolService.class);


    @Override
    public Student addStudent(Student student) {
        LOGGER.info("start of Student.addStudent with student  id "+student.getId());
        String sql = "INSERT INTO student (email, password, firstname, lastname, phoneNumber, gender, gradeLevel, parentNumber) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,student.getEmail(),student.getPassword(),student.getFirstname(),student.getLastname()
        ,student.getPhoneNumber(),student.getGender(),student.getGradeLevel(),student.getParentNumber());
        LOGGER.info("end of Student.addStudent with student id "+student.getId());
            return student;
    }



    @Override
    public String deleteStudent(Long id) {
        LOGGER.info("start of Student.deleteStudent with  id "+id);
        String sql = "DELETE FROM student WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected > 0) {
            LOGGER.info("end of Student.deleteStudent with  id "+id);
            return "Student with ID " + id + " has been successfully deleted.";
        } else {
            LOGGER.info("end of Student.deleteStudent with  id "+id);
            return "Student with ID " + id + " not found or could not be deleted.";
        }

    }


    @Override
    public List<Student> getAllStudent() {
        LOGGER.info("start of Student.getallstudent ");
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentMapper());
    }


    public Student getStudentById(Long id) {
        LOGGER.info("start of StudentService.getStudentById with  id "+id);
        String sql = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
    }

    @Override
    public String updateStudent(Long id,Student student) {
        if(existsById(id)) {
            String sql = "UPDATE student SET email = ?, password = ?, firstname = ?, lastname = ?, " +
                    "phoneNumber = ?, gender = ?, gradeLevel = ?, parentNumber = ? WHERE id = ?";
            jdbcTemplate.update(
                    sql,
                    student.getEmail(),
                    student.getPassword(),
                    student.getFirstname(),
                    student.getLastname(),
                    student.getPhoneNumber(),
                    student.getGender(),
                    student.getGradeLevel(),
                    student.getParentNumber(),
                    id
            );
            return "Success update";
        }
        else
            return "There is No student with this id "+id;
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM student WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }


    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from student",Integer.class);
    }





}
