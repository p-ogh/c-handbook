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

    @OneToMany(mappedBy = "trainingSession", cascade = CascadeType.ALL)
   private List<Exercise> exercises;// running, strength training, cycling, yoga


    public TrainingSession(UUID id, Date created, UUID teamId, String notes, String location, List<Exercise> exercises) {
        super(id, created, teamId, notes, location);
        this.exercises = exercises;
    }

    protected void updateTraining( List<Exercise> exercises) {
        this.exercises = exercises;  }
}
