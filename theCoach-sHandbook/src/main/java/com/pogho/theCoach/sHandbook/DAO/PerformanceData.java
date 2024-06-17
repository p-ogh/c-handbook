package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceData extends Record{

    private UUID sessionId;
    private UUID athleteId;
    private int rating;


    public void updatePerformanceData(int rating, String notes){
        super.update(notes);
        this.rating = rating;
    }
}
