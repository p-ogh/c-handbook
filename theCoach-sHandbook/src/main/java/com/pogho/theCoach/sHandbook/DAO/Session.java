package com.pogho.theCoach.sHandbook.DAO;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Session extends Record{
    private LocalDateTime scheduleDateTime;
    private LocalDateTime actualDateTime;
    private Exercise exerciseType;// running, strength training, cycling, yoga
    private int durationInMinutes;
    private int caloriesBurned;
    private IntensityLevel intensityLevel; //low,medium,high
    private int maxHeartRate;
    private String trainingFocus; //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    private int perceivedEffort;
    private int sessionRating;
    private int sorenessLevel;
    private Address location;
    private String sessionNotes;

}
