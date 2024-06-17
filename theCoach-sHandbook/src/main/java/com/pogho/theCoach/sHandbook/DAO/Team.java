package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
    @Id
    private UUID id;
    private String name;
    private String sport;
    private String status;
    private Date created;
    private List<UUID> seasons;


    public void updateTeam(String name, String sport, List<UUID> seasons) {
        this.name = name;
        this.sport = sport;
        this.seasons = seasons;
    }
}
