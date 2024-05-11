package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachModel extends MemberModel {
    private int yearsOfExperience;

    public CoachModel(String firstName, String lastName, int age, String gender, String role, String nationality, Date date, String status, int yearsOfExperience){
        super(firstName,lastName,age,gender,role,nationality,date,status);
        this.yearsOfExperience = yearsOfExperience;
    }
}
