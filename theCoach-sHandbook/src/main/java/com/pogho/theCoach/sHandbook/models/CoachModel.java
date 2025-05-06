package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CoachModel extends MemberModel {
    private int yearsOfExperience;

    public CoachModel(String firstName, String lastName,  int age, String gender, String role, List<UUID> seasons, Date date, String status, int yearsOfExperience){
        super(firstName, lastName, age, gender, role, seasons, date, status);
        this.yearsOfExperience = yearsOfExperience;
    }
}
