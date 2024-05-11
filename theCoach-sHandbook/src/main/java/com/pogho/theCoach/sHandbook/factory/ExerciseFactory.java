package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Exercise;
import com.pogho.theCoach.sHandbook.models.ExerciseModel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExerciseFactory {

    public Exercise createExercise(UUID sessionId, UUID athleteId, ExerciseModel model) {

    return new Exercise(UUID.randomUUID(), athleteId, new Date(), model.getNotes(), sessionId, model.getName(), model.getDuration(), model.getReps(), model.getSets());
    }

    public List<Exercise> createExercises(UUID sessionId, UUID athleteId, List<ExerciseModel> models){

       // List<Exercise> exercises = models.stream().map(model-> createExercise(model)).toList();
        //same as below.
        // List<Exercise> exercises =  models.stream().map(this::createExercise).toList();

        return models.stream().map(model -> createExercise(sessionId, athleteId, model)).toList();
    }
}