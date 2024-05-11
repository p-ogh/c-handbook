package com.pogho.theCoach.sHandbook.models;

import com.pogho.theCoach.sHandbook.enums.IntensityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlanModel extends AbstractSessionModel {

    private IntensityLevel intensityLevel; //low,medium,high
    private String trainingFocus;  //endurance, strength, flexibility, weightloss, speed, recovery, competition,
    private String location;
    private boolean completed;






}
