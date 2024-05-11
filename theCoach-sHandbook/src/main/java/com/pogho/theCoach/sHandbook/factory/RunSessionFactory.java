package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.RunSession;
import com.pogho.theCoach.sHandbook.models.RunExerciseModel;

import java.util.UUID;

public class RunSessionFactory {

    public RunSession createRun(UUID athleteId, RunExerciseModel runEntity) {

        return new RunSession();
    }
}