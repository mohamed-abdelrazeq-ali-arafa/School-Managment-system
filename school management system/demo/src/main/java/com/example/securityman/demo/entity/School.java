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
@Table("school")
public class School {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("address")
    private String address;

    @Column("contactNumber")
    private String contactNumber;

    @Column("about")
    private String about;


}
