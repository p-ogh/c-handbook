package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
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

    public Session(UUID id, Date created, UUID teamId, String notes, String location) {
        super(id, created, teamId, notes);
        this.location = location;
    }

    protected void updateSession(String notes, LocalDateTime start, LocalDateTime end, long duration, int rating, String location, String status) {
    super.update(notes);
        this.start = start;
        this.end= end;
        this.duration = duration;
        this.rating = rating;
        this.location = location;
        this.status = status;
    }
}
