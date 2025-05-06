package com.pogho.theCoach.sHandbook.models;

import jakarta.persistence.Column;
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
public class AthleteModel extends MemberModel {
    @Column(name="jersey_number")
    private int jerseyNumber;
    private double height;
    private double weight;
    private String availability;

    public AthleteModel(String firstName, String lastName, int age, String gender, String role, List<UUID> seasons, Date date, String status, int jerseyNumber, double height, double weight, String availability){
        super(firstName,lastName, age,gender,role,seasons,date,status);
        this.jerseyNumber =jerseyNumber;
        this.height = height;
        this.weight =weight;
        this.availability =availability;
    }
}
