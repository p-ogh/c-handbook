package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "session_table")
public class Session extends Record{
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
//    @Column(name = "exercises")
//    private List<Exercise> exercises;// running, strength training, cycling, yoga
    @Column(name = "duration")
    private long duration;
    @Column(name = "max_heart_rate")
    private int maxHeartRate;
    @Column(name = "calories_burned")
    private int caloriesBurned;
    @Column(name = "rating")
    private int rating;
    @Column(name = "soreness_level")
    private int sorenessLevel;
    private String location;

    public Session(UUID id, UUID athleteId, Date created, String notes, LocalDateTime startTime, LocalDateTime endTime, long duration, int maxHeartRate, int caloriesBurned, int rating, int sorenessLevel, String location) {
        super(id, athleteId, created, notes);
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.maxHeartRate = maxHeartRate;
        this.caloriesBurned = caloriesBurned;
        this.rating = rating;
        this.sorenessLevel = sorenessLevel;
        this.location = location;
    }

    protected void updateSession(String notes, LocalDateTime start, LocalDateTime end, int duration, int maxHeartRate, int caloriesBurned, int rating, int sorenessLevel, String location) {
    super.update(notes);
        this.startTime = start;
        this.endTime = end;
        this.duration = duration;
        this.maxHeartRate = maxHeartRate;
        this.caloriesBurned = caloriesBurned;
        this.rating = rating;
        this.sorenessLevel = sorenessLevel;
        this.location = location;  }
}
