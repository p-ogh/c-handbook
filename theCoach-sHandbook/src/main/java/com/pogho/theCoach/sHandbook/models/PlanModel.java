package com.pogho.theCoach.sHandbook.models;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanModel {

    private IntensityLevel intensityLevel; //low,medium,high
    private String trainingFocus;  //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    private String location;
    private boolean completed;
    private List<UUID> sessions;






}
