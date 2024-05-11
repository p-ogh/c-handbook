package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RunExerciseModel extends ExerciseModel {
    private int distance;
    private String equipment;
    private int kmPerLap;
    private int lapsCompleted;
}
