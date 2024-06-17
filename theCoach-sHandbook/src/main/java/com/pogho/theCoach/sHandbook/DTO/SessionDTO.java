package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO extends RecordDTO{
    private LocalDateTime start;
    private LocalDateTime end; //can be null
    private int duration;
    private int rating;
    private String location;
    private boolean teamSession;

    public SessionDTO(UUID id, LocalDateTime created, String notes, boolean teamSession, String location) {
        super(id, created, notes);
        this.teamSession = teamSession;
        this.location = location;
    }
}
