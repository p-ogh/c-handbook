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


//    public PracticeSession(UUID id, Date created,UUID teamId, String notes, String location, List<String> drills) {
//        super(id, created, teamId, notes, location);
//        this.drills = drills;
//    }
//
//    protected void updatePractice( List<String> drills) {
//        this.drills = drills;
//    }
}
