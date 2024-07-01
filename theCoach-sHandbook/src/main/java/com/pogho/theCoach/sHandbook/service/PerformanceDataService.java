package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.*;
import com.pogho.theCoach.sHandbook.DTO.*;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.PerformanceDataFactory;
import com.pogho.theCoach.sHandbook.factory.SessionFactory;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.PerformanceDataModel;
import com.pogho.theCoach.sHandbook.models.SessionModel;
import com.pogho.theCoach.sHandbook.repository.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PerformanceDataService {

    @Autowired
    private PerformanceDataRepository repository;

    @Autowired
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);
    private final PerformanceDataFactory factory = new PerformanceDataFactory();



    public List<PerformanceDataDTO> fetchData() {
        List<PerformanceData> data = repository.findAll();

        return data.stream().map(mapper::modelToDto).toList();
    }

    public List<PerformanceDataDTO> fetchSessionData(UUID sessionId) {
        List<PerformanceData> data = repository.findBySessionId(sessionId);
        return data.stream().map(mapper::modelToDto).toList();


    }

    public List<PerformanceDataDTO> fetchAthleteData(UUID athleteId) {
        List<PerformanceData> data = repository.findByAthleteId(athleteId);
        return data.stream().map(mapper::modelToDto).toList();
    }


    public List<PerformanceDataDTO> fetchAthleteData(UUID athleteId, String sessionType) {
        List<PerformanceData> data = repository.findByAthleteIdAndSessionType(athleteId, sessionType);
        return data.stream().map(mapper::modelToDto).toList();
    }


    public PerformanceDataDTO addNewData(PerformanceDataModel model) {
        PerformanceData data = factory.createData(model);
        repository.save(data);
        return mapper.modelToDto(data);

    }

    public PerformanceDataDTO updateData(UUID id, PerformanceDataModel model) {
        Optional<PerformanceData> optionalData = repository.findById(id);
        if(optionalData.isPresent()){
            PerformanceData data = optionalData.get();
            data.updateData(model.getNotes(),model.getRating());
            return mapper.modelToDto(data);
        }
        else {
            throw new NotFoundException("No Performance Data found with ID: " + id);
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
