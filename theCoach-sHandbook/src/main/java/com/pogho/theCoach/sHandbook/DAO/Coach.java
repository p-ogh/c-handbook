package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coach extends Member{
    private int yearsOfExperience;

    public Coach(UUID id, String firstName, String lastName, UUID teamID, int age, String gender, String role, List<UUID> seasons, Date date, String status, int yearsOfExperience) {
        super(id, firstName,lastName, teamID, age, gender,role,seasons,date,status);
        this.yearsOfExperience = yearsOfExperience;
    }

    public void updateCoach(String firstName, String lastName,UUID teamID, int age, String gender, String role, List<UUID> seasons, String status, int yearsOfExperience) {
    super.updateMember(firstName, lastName,teamID, age, gender, role, seasons,status);
    this.yearsOfExperience = yearsOfExperience;

    }
}
