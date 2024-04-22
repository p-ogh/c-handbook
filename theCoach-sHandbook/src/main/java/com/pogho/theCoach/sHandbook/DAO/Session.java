package com.pogho.theCoach.sHandbook.DAO;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import jakarta.persistence.Column;
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
    @Column(name = "scheduled_date_time")
    private LocalDateTime scheduledDateTime;
    @Column(name = "actual_date_time")
    private LocalDateTime actualDateTime;
  //  private Exercise exerciseType;// running, strength training, cycling, yoga
    @Column(name = "duration_minutes")
    private int durationMinutes;
    @Column(name = "calories_burned")
    private int caloriesBurned;
    @Column(name = "intensity_level")
    private IntensityLevel intensityLevel; //low,medium,high
    @Column(name = "max_heart_rate")
    private int maxHeartRate;
    @Column(name = "training_focus")
    private String trainingFocus; //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    @Column(name = "perceived_effort")
    private int perceivedEffort;
    @Column(name = "session_rating")
    private int sessionRating;
    @Column(name = "soreness_level")
    private int sorenessLevel;
    private String location;
    @Column(name = "session_notes")
  private String sessionNotes;

  protected void updateSession(LocalDateTime scheduledDateTime, LocalDateTime actualDateTime, int durationMinutes, int caloriesBurned, IntensityLevel intensityLevel, int maxHeartRate, String trainingFocus, int perceivedEffort, int sessionRating, int sorenessLevel, String location, String sessionNotes) {
    this.scheduledDateTime = scheduledDateTime;
    this.actualDateTime = actualDateTime;
    this.durationMinutes = durationMinutes;
    this.caloriesBurned = caloriesBurned;
    this.intensityLevel = intensityLevel;
    this.maxHeartRate = maxHeartRate;
    this.trainingFocus = trainingFocus;
    this.perceivedEffort = perceivedEffort;
    this.sessionRating = sessionRating;
    this.sorenessLevel = sorenessLevel;
    this.location = location;
    this.sessionNotes = sessionNotes;
  }
}
