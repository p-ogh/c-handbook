package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fitnessStats")
public class FitnessStats extends Entry {

    private double height;
    private double weight;
    private int restingHeartRate;
    private int maxHeartRate;
    private int sleepDuration;
    private int sleepQualityRating;
    private int sorenessLevel;
    private Date dateAdded;


}
