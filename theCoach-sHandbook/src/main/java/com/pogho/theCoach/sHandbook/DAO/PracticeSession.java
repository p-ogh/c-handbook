package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = true)
public class PracticeSession extends Session{

   private String focus;


   public PracticeSession(UUID id, Date created, UUID teamId, String notes, String location, Boolean teamSession, List<UUID> participants, String status, String sessionType, String focus) {
      super(id, created, teamId, notes, location, teamSession, participants, status, sessionType);
      this.focus = focus;
   }

    public void updatePractice(String focus) {
        this.focus = focus;
    }
}
