package com.example.securityman.demo.Mappers;


import com.example.securityman.demo.entity.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentMapper  implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setEmail(rs.getString("email"));
        student.setPassword(rs.getString("password"));
        student.setFirstname(rs.getString("firstname"));
        student.setLastname(rs.getString("lastname"));
        student.setPhoneNumber(rs.getString("phoneNumber"));
        student.setGender(rs.getString("gender"));
        student.setGradLevel(rs.getString("gradLevel"));
        student.setParentNumber(rs.getString("parentNumber"));
        return student;
    }
}
