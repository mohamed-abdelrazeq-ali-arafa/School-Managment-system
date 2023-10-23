package com.example.securityman.demo.entity;



import lombok.*;
import  com.fasterxml.jackson.annotation.JsonIgnore;;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
//@Table("student")
@Entity
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
    private String gradLevel;

    @Column("parentNumber")
    private String parentNumber;


    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses=new HashSet<>();

}
