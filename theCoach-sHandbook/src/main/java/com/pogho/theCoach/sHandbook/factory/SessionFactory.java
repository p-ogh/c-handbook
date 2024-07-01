package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.*;
import com.pogho.theCoach.sHandbook.models.MatchSessionModel;
import com.pogho.theCoach.sHandbook.models.PracticeSessionModel;
import com.pogho.theCoach.sHandbook.models.SessionModel;
import com.pogho.theCoach.sHandbook.models.TrainingSessionModel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SessionFactory {
    private final ExerciseFactory exerciseFactory = new ExerciseFactory();


    public Session createSession(SessionModel sessionModel) {

    //    long duration = Duration.between(model.getStart(), model.getEnd()).toMinutes();

        Session session = new Session();

        if (sessionModel instanceof TrainingSessionModel model) {
            List<Exercise> exercises = exerciseFactory.createExercises(model.getExercises());
            List<UUID> exerciseIds = exercises.stream().map(Exercise::getId).toList();
            session = new TrainingSession(UUID.randomUUID(), new Date(), model.getTeamId(), model.getNotes(), model.getLocation(), model.isTeamSession(), model.getParticipants(), "new","training", exerciseIds);
        } else if (sessionModel instanceof PracticeSessionModel practiceSessionModel) {

            session = new PracticeSession(UUID.randomUUID(), new Date(), practiceSessionModel.getTeamId(), practiceSessionModel.getNotes(), practiceSessionModel.getLocation(), practiceSessionModel.isTeamSession(), practiceSessionModel.getParticipants(), "new", "practice", practiceSessionModel.getFocus());
        } else if (sessionModel instanceof MatchSessionModel matchSessionModel) {

            session = new MatchSession(UUID.randomUUID(), new Date(), matchSessionModel.getTeamId(), matchSessionModel.getNotes(), matchSessionModel.isTeamSession(), matchSessionModel.getParticipants(),  "new","game", matchSessionModel.getLocation(), matchSessionModel.getOpponent(), matchSessionModel.isHome(), matchSessionModel.getTeamScore(), matchSessionModel.getOpponentScore());
        }
//        return new Session(UUID.randomUUID(), new Date(), model.getTeamId(), model.getNotes(), model.getLocation(), model.isTeamSession(), model.getParticipants(), "new");
        return session;
    }
}