package com.pogho.theCoach.sHandbook.models;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseModel {
    private String name;
    private int duration;
    private int reps;
    private int sets;
    private String notes;
}
