package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SessionModel extends RecordModel {

    private LocalDateTime start;
    private LocalDateTime end; //can be null
    private int duration;
    private int rating;
    private String location;
    private boolean teamSession;

    public SessionModel(Date created, String notes, boolean teamSession, String location) {
        super(created, notes);
        this.teamSession = teamSession;
        this.location = location;
    }

}
