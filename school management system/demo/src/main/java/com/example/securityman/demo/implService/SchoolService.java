package com.example.securityman.demo.implService;


import com.example.securityman.demo.Mappers.SchoolMapper;
import com.example.securityman.demo.entity.School;

import com.example.securityman.demo.service.ISchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService   implements ISchoolService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolService.class);


    @Override
    public  School addSchool(School school) {
        LOGGER.info("start of SchoolService.addschool with school id "+school.getId());
        String sql = "INSERT INTO school (name, address, contactNumber, about) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, school.getName(), school.getAddress(), school.getContactNumber(), school.getAbout());
        return school;
    }



    @Override
    public String deleteSchool(Long id) {
        String sql = "DELETE FROM school WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected > 0) {
            return "School with ID " + id + " has been successfully deleted.";
        } else {
            return "School with ID " + id + " not found or could not be deleted.";
        }
    }


    @Override
    public List<School> getAllSchool() {
        String sql = "SELECT * FROM school";
        return jdbcTemplate.query(sql, new SchoolMapper());
    }


    public School getSchoolById(Long id) {
        LOGGER.info("start of SchoolService.getSchoolById with  id "+id);
        String sql = "SELECT * FROM school WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new SchoolMapper());
    }

    @Override
    public String updateSchool(Long id,School school) {
        LOGGER.info("start of SchoolService.updateschool");
        if(existsById(id)) {
            String sql = "UPDATE school SET name = ?, address = ?, contactNumber = ?, about = ? WHERE id = ?";
            jdbcTemplate.update(
                    sql,
                    school.getName(),
                    school.getAddress(),
                    school.getContactNumber(),
                    school.getAbout(),
                    id
            );
            return "Success update";
        }
        else
            return "There is No school with this id";
    }

    @Override
    public boolean existsById(Long id) {
            String sql = "SELECT COUNT(*) FROM school WHERE id = ?";
            int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
            return count > 0;
        }


    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from school",Integer.class);
    }
}
