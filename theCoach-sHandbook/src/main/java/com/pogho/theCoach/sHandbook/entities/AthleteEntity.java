package com.pogho.theCoach.sHandbook.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteEntity extends MemberEntity{
    private String sport;
    @Column(name="jersey_number")
    private int jerseyNumber;
    private double height;
    private double weight;
    private String availability;

    public AthleteEntity(String firstName, String lastName, int age, String gender, String role, String nationality, Date date, String status,String sport, int jerseyNumber, double height, double weight, String availability){
        super(firstName,lastName,age,gender,role,nationality,date,status);
        this.sport = sport;
        this.jerseyNumber =jerseyNumber;
        this.height = height;
        this.weight =weight;
        this.availability =availability;
    }
}
