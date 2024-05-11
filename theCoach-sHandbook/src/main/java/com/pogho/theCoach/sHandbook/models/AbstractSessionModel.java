package com.pogho.theCoach.sHandbook.models;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractSessionModel {

    private String name;
    private List<ExerciseModel> exercises;
    private String notes;
}
