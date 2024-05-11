package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String role;
    private String nationality;
    private Date dateAdded;
    private String status;
}
