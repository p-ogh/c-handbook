package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RunSessionDTO extends SessionDTO{
    private int distanceInKMs;
    private String equipmentUsed;
    private int kmPerLap;
    private int lapsCompleted;
    private int avgSpeed;//lmperminute
}
