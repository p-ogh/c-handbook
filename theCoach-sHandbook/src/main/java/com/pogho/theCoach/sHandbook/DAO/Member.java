package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Member {
    @Id
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    private String gender;
    private String role;
    private String nationality;
    @Column(name = "date_added")
    private Date dateAdded;
    private String status;

    public Member(UUID id, String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;

    }

    public void updateMember(String firstName, String lastName, int age, String gender, String role, String nationality, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.nationality = nationality;
        this.status = status;
    }
}
