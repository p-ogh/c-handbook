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
public class SessionDTO extends RecordDTO{
    private LocalDateTime start;
    private LocalDateTime end;
    private int duration;
    private int caloriesBurned;
    private IntensityLevel intensityLevel; //low,medium,high
    private int maxHeartRate;
  //  private String trainingFocus; //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    private int rating;
    private int sorenessLevel;
    private String location;

    public SessionDTO(UUID id, UUID athleteId, LocalDateTime created, String notes, LocalDateTime start, LocalDateTime end, int duration, int caloriesBurned, IntensityLevel intensityLevel, int maxHeartRate, int rating, int sorenessLevel, String location) {
        super(id, athleteId, created, notes);
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.intensityLevel = intensityLevel;
        this.maxHeartRate = maxHeartRate;
        this.rating = rating;
        this.sorenessLevel = sorenessLevel;
        this.location = location;
    }
}
