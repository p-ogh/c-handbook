package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.*;
import com.pogho.theCoach.sHandbook.models.*;

import java.util.Date;
import java.util.UUID;

public class PerformanceDataFactory {

    public PerformanceData createData(PerformanceDataModel model) {

        return new PerformanceData(UUID.randomUUID(), new Date(), model.getTeamId(), model.getNotes(), model.getSessionId(), model.getSessionType(), model.getAthleteId(), model.getRating());
    }
}