package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private String status;
    private boolean teamSession;
    private List<UUID> participants;
    private String sessionType;

    public SessionModel(UUID teamId, Date created, String notes, boolean teamSession, List<UUID> participants, String location, String sessionType) {
        super(teamId, created, notes);
        this.teamSession = teamSession;
        this.location = location;
        this.participants = participants;
        this.sessionType = sessionType;
    }

}
