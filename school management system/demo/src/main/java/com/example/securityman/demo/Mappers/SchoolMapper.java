package com.example.securityman.demo.Mappers;

import com.example.securityman.demo.entity.School;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SchoolMapper implements RowMapper<School> {

    @Override
    public School mapRow(ResultSet rs, int rowNum) throws SQLException {
        School school = new School();
        school.setId(rs.getLong("id"));
        school.setName(rs.getString("name"));
        school.setAddress(rs.getString("address"));
        school.setContactNumber(rs.getString("contactNumber"));
        school.setAbout(rs.getString("about"));
        return school;
    }
}
