package com.pogho.theCoach.sHandbook.entities;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionEntity extends RecordEntity{
    private LocalDateTime scheduledDateTime;
    private LocalDateTime actualDateTime;
    private int durationMinutes;
    private int caloriesBurned;
    private IntensityLevel intensityLevel; //low,medium,high
    private int maxHeartRate;
    private String trainingFocus; //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    private int perceivedEffort;
    private int sessionRating;
    private int sorenessLevel;
   // private boolean completed;
    private String location;
    private String sessionNotes;
}
