package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Exercise;
import com.pogho.theCoach.sHandbook.DAO.Session;
import com.pogho.theCoach.sHandbook.models.SessionModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SessionFactory {


    public Session createSession(UUID athleteId, SessionModel model) {

        long duration = Duration.between(model.getStart(), model.getEnd()).toMinutes();

        return new Session(UUID.randomUUID(), athleteId, new Date(), model.getNotes(), model.getStart(), model.getEnd(), duration, model.getMaxHeartRate(), model.getCaloriesBurned(), model.getRating(), model.getSorenessLevel(), model.getLocation());
    }
}