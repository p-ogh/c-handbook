package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {
    private String firstName;
    private String lastName;
    private UUID teamID;
    private int age;
    private String gender;
    private String role;
    private List<UUID> seasons;
    private Date dateAdded;
    private String status;
}
