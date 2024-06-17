package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Session;
import com.pogho.theCoach.sHandbook.models.SessionModel;

import java.util.Date;
import java.util.UUID;

public class SessionFactory {


    public Session createSession(UUID teamId, SessionModel model) {

    //    long duration = Duration.between(model.getStart(), model.getEnd()).toMinutes();

        return new Session(UUID.randomUUID(), new Date(), teamId, model.getNotes(), model.getLocation());
    }
}