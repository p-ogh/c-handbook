package com.pogho.theCoach.sHandbook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String role;
    private String nationality;
    private Date dateAdded;
    private String status;
}
