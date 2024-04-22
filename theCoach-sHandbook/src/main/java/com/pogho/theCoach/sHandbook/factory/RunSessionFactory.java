package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.RunSession;
import com.pogho.theCoach.sHandbook.entities.RunSessionEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class RunSessionFactory {

    public RunSession createRun(UUID athleteId, RunSessionEntity runEntity) {
      //  int avgSpeed = runEntity.getDistanceInKMs()/runEntity.getDurationMinutes();

        RunSession run = new RunSession(UUID.randomUUID(), athleteId,  LocalDateTime.now(), runEntity.getScheduledDateTime(), runEntity.getActualDateTime(), runEntity.getDurationMinutes(), runEntity.getCaloriesBurned(), runEntity.getIntensityLevel(), runEntity.getMaxHeartRate(), runEntity.getTrainingFocus(), runEntity.getPerceivedEffort(), runEntity.getSessionRating(), runEntity.getSorenessLevel(), runEntity.getLocation(), runEntity.getSessionNotes(),runEntity.getDistanceInKMs(),runEntity.getEquipmentUsed(), runEntity.getKmPerLap(), runEntity.getLapsCompleted());
        return run;
    }
}