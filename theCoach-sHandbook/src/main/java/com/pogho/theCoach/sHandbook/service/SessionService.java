package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.*;
import com.pogho.theCoach.sHandbook.DTO.PracticeSessionDTO;
import com.pogho.theCoach.sHandbook.DTO.MatchSessionDTO;
import com.pogho.theCoach.sHandbook.DTO.SessionDTO;
import com.pogho.theCoach.sHandbook.DTO.TrainingSessionDTO;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.SessionFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.SessionModel;
import com.pogho.theCoach.sHandbook.repository.MatchSessionRepository;
import com.pogho.theCoach.sHandbook.repository.PracticeSessionRepository;
import com.pogho.theCoach.sHandbook.repository.SessionRepository;
import com.pogho.theCoach.sHandbook.repository.TrainingSessionRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private TrainingSessionRepository trainingSessionRepository;
    @Autowired
    private MatchSessionRepository matchSessionRepository;
    @Autowired
    private PracticeSessionRepository practiceSessionRepository;
    @Autowired
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final SessionFactory sessionFactory = new SessionFactory();



    public List<SessionDTO> fetchSessions() {
        List<Session> sessions = sessionRepository.findAll();

        return sessions.stream().map(mapper::modelToDto).toList();
    }

    public List<TrainingSessionDTO> fetchTrainingSessions() {
        List<TrainingSession> sessions = trainingSessionRepository.findAll();
        return sessions.stream().map(mapper::modelToDto).toList();


    }

    public List<MatchSessionDTO> fetchMatchSessions() {
        List<MatchSession> sessions = matchSessionRepository.findAll();
        return sessions.stream().map(mapper::modelToDto).toList();
    }

    public List<PracticeSessionDTO> fetchPracticeSessions() {
        List<PracticeSession> sessions = practiceSessionRepository.findAll();
        return sessions.stream().map(mapper::modelToDto).toList();
    }

    public SessionDTO addNewSession(SessionModel model) {
        Session session = sessionFactory.createSession(model);
        sessionRepository.save(session);
        return mapper.modelToDto(session);



    }

    public SessionDTO startSession(UUID id) {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if(optionalSession.isPresent()){
            Session session = optionalSession.get();
            session.startSession(LocalDateTime.now(), "active");
            return mapper.modelToDto(session);
        }
        else {
            throw new NotFoundException("No Session found with ID: " + id);
        }

    }

    public SessionDTO endSession(UUID id) {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if(optionalSession.isPresent()){
            Session session = optionalSession.get();
            session.endSession(LocalDateTime.now(), "completed");
            return mapper.modelToDto(session);
        }
        else {
            throw new NotFoundException("No Session found with ID: " + id);
        }
    }

    public SessionDTO updateSession(UUID id, SessionModel model) {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if(optionalSession.isPresent()){
            Session session = optionalSession.get();
            session.updateSession(model.getNotes(), model.getStart(), model.getEnd(), model.getDuration(), model.getRating(), model.getLocation(), model.isTeamSession(),model.getParticipants(), model.getStatus());
            return mapper.modelToDto(session);
        }
        else {
            throw new NotFoundException("No Session found with ID: " + id);
        }
    }
//
//    public TrainingSessionDTO addAthleteSession(UUID athleteId, SessionModel model) {
//        RecordValidation.validate(athleteId);
//        Session session = sessionFactory.createSession(athleteId, model);
//        List<Exercise> exercises = exerciseFactory.createExercises(session.getId(), athleteId, model.getExercises());
//
//        sessionRepository.save(session);
//        exercises.forEach(exercise->exerciseRepository.save(exercise));
//
//        return ModelMapper.MAPPER.modelToDto(session);
//    }
}
