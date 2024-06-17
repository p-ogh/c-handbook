package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Exercise;
import com.pogho.theCoach.sHandbook.DAO.TrainingSession;
import com.pogho.theCoach.sHandbook.models.ExerciseModel;

import java.util.List;
import java.util.UUID;

public class ExerciseFactory {

    public Exercise createExercise(TrainingSession session, ExerciseModel model) {

    return new Exercise(UUID.randomUUID(), model.getName(), model.getDuration(), model.getReps(), model.getSets(), session);
    }

    public List<Exercise> createExercises(TrainingSession session, List<ExerciseModel> models){


        return models.stream().map(model -> createExercise(session, model)).toList();
    }
}