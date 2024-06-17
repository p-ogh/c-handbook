package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Athlete extends Member{
    @Column(name="jersey_number")
    private int jerseyNumber;
    private double height;
    private double weight;
    private String availability;


    public Athlete(UUID id, String firstName, String lastName, UUID teamID, int age,  String gender, String role, List<UUID> seasons, Date date, String status, int jerseyNumber, double height, double weight, String availability) {
        super(id, firstName,lastName, teamID, age, gender,role,seasons,date,status);
        this.jerseyNumber = jerseyNumber;
        this.height = height;
        this.weight = weight;
        this.availability = availability;
    }


    public void updateAthlete(String firstName, String lastName, UUID teamID, int age, String gender, String role, List<UUID> seasons, String status, int jerseyNumber, double height, double weight, String availability) {
        super.updateMember(firstName, lastName, teamID, age, gender, role, seasons, status);
        this.jerseyNumber = jerseyNumber;
        this.height = height;
        this.weight = weight;
        this.availability = availability;

    }
}
