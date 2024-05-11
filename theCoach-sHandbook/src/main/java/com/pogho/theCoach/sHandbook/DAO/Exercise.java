package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Exercise extends Record{
    private UUID sessionId;
    private String name;
    private int duration;
    private int reps;
    private int sets;

    public Exercise(UUID id, UUID athleteId, Date created, String notes, UUID sessionId, String name, int duration, int reps, int sets) {
        super(id, athleteId, created, notes);
        this.sessionId = sessionId;
        this.name = name;
        this.duration = duration;
        this.reps = reps;
        this.sets = sets;
    }
}
