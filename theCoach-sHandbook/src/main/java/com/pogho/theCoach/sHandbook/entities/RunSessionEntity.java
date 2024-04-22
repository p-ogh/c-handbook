package com.pogho.theCoach.sHandbook.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunSessionEntity extends SessionEntity{
    private int distanceInKMs;
    private String equipmentUsed;
    private int kmPerLap;
    private int lapsCompleted;

}
