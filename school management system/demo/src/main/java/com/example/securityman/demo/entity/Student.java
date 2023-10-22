package com.example.securityman.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("student")
public class Student  {
    @Id
    @Column("id")
    private Long id;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("firstname")
    private String firstname;

    @Column("lastname")
    private String lastname;

    @Column("phoneNumber")
    private String phoneNumber;

    @Column("gender")
    private String gender;

    @Column("gradeLevel")
    private String gradeLevel;

    @Column("parentNumber")
    private String parentNumber;





}
