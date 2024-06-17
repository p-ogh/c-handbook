package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Run;
import com.pogho.theCoach.sHandbook.models.RunExerciseModel;

import java.util.UUID;

public class RunFactory {

    public Run createRun(UUID athleteId, RunExerciseModel runEntity) {

        return new Run();
    }
}