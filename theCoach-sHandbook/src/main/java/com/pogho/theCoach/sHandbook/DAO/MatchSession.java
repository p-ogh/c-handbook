package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
public class MatchSession extends Session{

   private String opponent;
   private boolean home;
   private int teamScore;
   private int opponentScore;


    public MatchSession(UUID id, Date created, UUID teamId, String notes, String location, String opponent, boolean home, int teamScore, int opponentScore) {
        super(id, created, teamId, notes, location);
        this.opponent = opponent;
        this.home = home;
        this.teamScore = teamScore;
        this.opponentScore = opponentScore;
    }

    protected void updateMatch(String opponent, boolean home, int teamScore, int opponentScore) {
        this.opponent = opponent;
        this.home = home;
        this.teamScore = teamScore;
        this.opponentScore = opponentScore;
    }
}
