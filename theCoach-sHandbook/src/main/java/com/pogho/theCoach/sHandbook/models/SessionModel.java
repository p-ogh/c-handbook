package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SessionModel extends AbstractSessionModel {
    private UUID athleteId;
    private UUID programId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int maxHeartRate;
    private int caloriesBurned;
    private String location;
    private int rating;
    private int sorenessLevel;

}
