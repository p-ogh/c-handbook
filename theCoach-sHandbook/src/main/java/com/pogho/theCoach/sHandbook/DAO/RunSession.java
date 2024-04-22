package com.pogho.theCoach.sHandbook.DAO;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RunSession extends Session{
    @Column(name = "distance_kms")
    private int distanceInKMs;
    @Column(name = "equipment_used")
    private String equipmentUsed;
    @Column(name = "km_per_lap")
    private int kmPerLap;
    @Column(name = "laps_completed")
    private int lapsCompleted;
    @Column(name = "avg_speed")
    private int avgSpeed;

    public RunSession(UUID uuid, UUID athleteId, LocalDateTime now, LocalDateTime scheduledDateTime, LocalDateTime actualDateTime, int durationMinutes, int caloriesBurned, IntensityLevel intensityLevel, int maxHeartRate, String trainingFocus, int perceivedEffort, int sessionRating, int sorenessLevel, String location, String sessionNotes, int distanceInKms, String equipmentUsed, int kmPerLap, int lapsCompleted) {
        int avgSpeed = distanceInKMs/durationMinutes;
        super.updateSession(scheduledDateTime,actualDateTime, durationMinutes, caloriesBurned, intensityLevel, maxHeartRate, trainingFocus, perceivedEffort, sessionRating, sorenessLevel, location, sessionNotes );
        this.distanceInKMs = distanceInKms;
        this.equipmentUsed = equipmentUsed;
        this.kmPerLap = kmPerLap;
        this.lapsCompleted = lapsCompleted;
        this.avgSpeed = avgSpeed;
    }


    public void updateRun(LocalDateTime scheduledDateTime, LocalDateTime actualDateTime, int durationMinutes, int caloriesBurned, IntensityLevel intensityLevel,int maxHeartRate, String trainingFocus, int perceivedEffort, int sessionRating, int sorenessLevel, String location, String sessionNotes, int distanceInKMS, String equipmentUsed,int kmPerLap,
    int lapsCompleted) {

        int avgSpeed = distanceInKMs/durationMinutes;
        super.updateSession(scheduledDateTime,actualDateTime, durationMinutes, caloriesBurned, intensityLevel, maxHeartRate, trainingFocus, perceivedEffort, sessionRating, sorenessLevel, location, sessionNotes );
        this.distanceInKMs = distanceInKMS;
        this.equipmentUsed = equipmentUsed;
        this.kmPerLap = kmPerLap;
        this.lapsCompleted = lapsCompleted;
        this.avgSpeed = avgSpeed;
    }

}
