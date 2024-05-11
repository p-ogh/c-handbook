package com.pogho.theCoach.sHandbook.DTO;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RunSessionDTO {
    private int distanceInKMs;
    private String equipmentUsed;
    private int kmPerLap;
    private int lapsCompleted;
    private int avgSpeed;//lmperminute

    public RunSessionDTO(UUID id, UUID athleteId, LocalDateTime created, LocalDateTime scheduledDateTime, LocalDateTime actualDateTime, int durationMinutes, int caloriesBurned, IntensityLevel intensityLevel, int maxHeartRate, String trainingFocus, int perceivedEffort, int sessionRating, int sorenessLevel, boolean completed, String location, String sessionNotes, int distanceInKMs, String equipmentUsed, int kmPerLap, int lapsCompleted) {

      //  super(id, athleteId, created, scheduledDateTime, actualDateTime, durationMinutes, caloriesBurned, intensityLevel, maxHeartRate, trainingFocus, perceivedEffort, sessionRating, sorenessLevel, completed, location, sessionNotes);
        this.distanceInKMs = distanceInKMs;
        this.equipmentUsed = equipmentUsed;
        this.kmPerLap = kmPerLap;
        this.lapsCompleted = lapsCompleted;
        this.avgSpeed = distanceInKMs/durationMinutes;
    }


}
