package com.pogho.theCoach.sHandbook.DTO;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;

import java.time.LocalDateTime;

public class SessionDTO extends RecordDTO{
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
    private boolean completed;
    private String location;
    private String sessionNotes;
}
