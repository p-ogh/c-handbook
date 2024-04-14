package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coach extends Member{
    private int yearsOfExperience;

    public Coach(UUID id, String firstName, String lastName, int age, String gender, String role, String nationality, Date date, String status, int yearsOfExperience) {
        super(id, firstName,lastName,age, gender,role,nationality,date,status);
        this.yearsOfExperience = yearsOfExperience;
    }

    public void updateCoach(String firstName, String lastName, int age, String gender, String role, String nationality, String status, int yearsOfExperience) {
    super.updateMember(firstName, lastName, age, gender, role, nationality,status);
    this.yearsOfExperience = yearsOfExperience;

    }
}
