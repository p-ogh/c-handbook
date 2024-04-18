package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RunningSession extends Session{
    private int distanceInKMs;
    private String equipmentUsed;
    private int kmPerLap;
    private int lapsCompleted;
    private int avgSpeed;

}
