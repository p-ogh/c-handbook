package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceData extends Record{

    private UUID sessionId;
    private String sessionType;
    private UUID athleteId;
    private int rating;

    public PerformanceData(UUID id, Date date, UUID teamId, String notes, UUID sessionId, String sessionType, UUID athleteId, int rating) {
        super(id,date,teamId,notes);
        this.sessionId = sessionId;
        this.sessionType = sessionType;
        this.athleteId = athleteId;
        this.rating = rating;
    }


    public void updateData(String notes, int rating){
        super.update(notes);
        this.rating = rating;
    }
}
