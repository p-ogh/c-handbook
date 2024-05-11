package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Athlete  extends Member{
    @Column(name="jersey_number")
    private int jerseyNumber;
    private double height;
    private double weight;
    private String availability;

    public Athlete(UUID id, String firstName, String lastName, int age, String gender, String role, String nationality, Date date, String status, int jerseyNumber, double height, double weight, String availability) {
        super(id, firstName, lastName, age, gender, role, nationality, date, status);
        this.jerseyNumber = jerseyNumber;
        this.height = height;
        this.weight = weight;
        this.availability = availability;
    }


    public void updateAthlete(String firstName, String lastName, int age, String gender, String role, String nationality, String status, int jerseyNumber, double height, double weight, String availability) {
        super.updateMember(firstName, lastName, age, gender, role, nationality,status);
        this.jerseyNumber =jerseyNumber;
        this.height =height;
        this.weight =weight;
        this.availability = availability;

    }
}
