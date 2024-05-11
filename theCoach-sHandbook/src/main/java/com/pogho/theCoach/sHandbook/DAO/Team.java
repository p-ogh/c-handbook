package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    public void updateTeam(String name, String sport) {
        this.name = name;
        this.sport = sport;
    }
}
