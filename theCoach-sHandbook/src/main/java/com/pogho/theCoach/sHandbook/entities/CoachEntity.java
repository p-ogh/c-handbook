package com.pogho.theCoach.sHandbook.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachEntity extends MemberEntity{
    private int yearsOfExperience;

    public CoachEntity(String firstName, String lastName, int age, String gender, String role, String nationality, Date date, String status, int yearsOfExperience){
        super(firstName,lastName,age,gender,role,nationality,date,status);
        this.yearsOfExperience = yearsOfExperience;
    }
}
