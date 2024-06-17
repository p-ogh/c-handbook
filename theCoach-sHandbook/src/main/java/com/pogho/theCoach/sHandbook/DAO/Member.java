package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
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
    private UUID teamId;
    private int age;
    private String gender;
    private String role;
    private List<UUID> seasons;
    @Column(name = "date_added")
    private Date dateAdded;
    private String status;


    public void updateMember(String firstName, String lastName,  UUID teamID, int age, String gender, String role, List<UUID> seasons, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamID;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.seasons = seasons;
        this.status = status;
    }
}
