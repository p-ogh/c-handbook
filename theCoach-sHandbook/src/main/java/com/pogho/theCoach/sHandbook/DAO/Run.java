package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Run extends Exercise{
    @Column(name = "distance_kms")
    private int distanceInKMs;
    @Column(name = "equipment_used")
    private String equipmentUsed;
    @Column(name = "km_per_lap")
    private int kmPerLap;
    @Column(name = "laps_completed")
    private int lapsCompleted;
    @Column(name = "avg_speed")
    private int avgSpeed;

}
