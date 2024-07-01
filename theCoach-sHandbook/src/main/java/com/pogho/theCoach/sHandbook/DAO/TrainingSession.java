package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
public class TrainingSession extends Session{

   private List<UUID> exercises;// running, strength training, cycling, yoga


    public TrainingSession(UUID id, Date created, UUID teamId, String notes, String location, Boolean teamSession, List<UUID> participants, String status, String sessionType, List<UUID> exercises) {
        super(id, created, teamId, notes, location, teamSession, participants, status, sessionType);
        this.exercises = exercises;
    }

    protected void updateTraining( List<UUID> exercises) {
        this.exercises = exercises;
    }
}
