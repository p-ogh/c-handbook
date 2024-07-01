package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "session_table")
public class Session extends Record{
    private LocalDateTime start;

    @Column(name = "end_time")
    private LocalDateTime end;
    private long duration;
    private int rating;
    private String location;
    private String status; //status could be new, active, completed
    private boolean teamSession;
    private List<UUID> participants;
    private String sessionType;



    public Session(UUID id, Date created, UUID teamId, String notes, String location, Boolean teamSession, List<UUID> participants, String status, String sessionType) {
        super(id, created, teamId, notes);
        this.location = location;
        this.status = status;
        this.teamSession = teamSession;
        this.participants = participants;
        this.sessionType = sessionType;
    }

    public void updateSession(String notes, LocalDateTime start, LocalDateTime end, long duration, int rating, String location, Boolean teamSession, List<UUID> participants, String status) {
    super.update(notes);
        this.start = start;
        this.end= end;
        this.duration = duration;
        this.rating = rating;
        this.location = location;
        this.teamSession = teamSession;
        this.status = status;
        this.participants = participants;
    }
    public void startSession(LocalDateTime start, String status){
        this.start = start;
        this.status = status;
    }

    public void endSession(LocalDateTime end, String status){
        this.end = end;
        this.status = status;
    }
}
