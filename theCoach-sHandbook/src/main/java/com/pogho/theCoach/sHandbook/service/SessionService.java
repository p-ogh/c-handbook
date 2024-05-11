package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Exercise;
import com.pogho.theCoach.sHandbook.DAO.Session;
import com.pogho.theCoach.sHandbook.DTO.SessionDTO;
import com.pogho.theCoach.sHandbook.factory.ExerciseFactory;
import com.pogho.theCoach.sHandbook.models.SessionModel;
import com.pogho.theCoach.sHandbook.factory.SessionFactory;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.repository.ExerciseRepository;
import com.pogho.theCoach.sHandbook.repository.SessionRepository;
import com.pogho.theCoach.sHandbook.validations.RecordValidation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final SessionFactory sessionFactory = new SessionFactory();
    private final ExerciseFactory exerciseFactory = new ExerciseFactory();



    public List<SessionDTO> fetchSessions() {
        List<Session> sessions = sessionRepository.findAll();

        return sessions.stream().map(mapper::modelToDto).toList();

    }

    public SessionDTO addAthleteSession(UUID athleteId, SessionModel model) {
        RecordValidation.validate(athleteId);
        Session session = sessionFactory.createSession(athleteId, model);
        List<Exercise> exercises = exerciseFactory.createExercises(session.getId(), athleteId, model.getExercises());

        sessionRepository.save(session);
        exercises.forEach(exercise->exerciseRepository.save(exercise));

        return ModelMapper.MAPPER.modelToDto(session);
    }
}
