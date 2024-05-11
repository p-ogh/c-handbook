package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.RunSession;
import com.pogho.theCoach.sHandbook.DTO.RunSessionDTO;
import com.pogho.theCoach.sHandbook.models.RunExerciseModel;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.RunSessionFactory;
import com.pogho.theCoach.sHandbook.mapper.RecordMapper;
import com.pogho.theCoach.sHandbook.repository.AthleteRepository;
import com.pogho.theCoach.sHandbook.repository.RunRepository;
import com.pogho.theCoach.sHandbook.validations.RecordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RunService {

    @Autowired
    private RunRepository runRepository;
    @Autowired
    private AthleteRepository athleteRepository;
    private final RunSessionFactory runFactory = new RunSessionFactory();


    public List<RunSessionDTO> fetchRunsList() {
        List<RunSession> runs = runRepository.findAll();
        List<RunSessionDTO> runDTOs = new ArrayList<>();
        runs.forEach(run-> runDTOs.add(RecordMapper.toDto(run)));
        return runDTOs;
    }

    public List<RunSessionDTO> fetchRunsListByAthlete(UUID oid) {
        Optional<Athlete> optionalAthlete = athleteRepository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalAthlete.isPresent()){
            List<RunSession> runs = runRepository.findAllRuns(oid);
            List<RunSessionDTO> runDTOs = new ArrayList<>();
            runs.forEach(run-> runDTOs.add(RecordMapper.toDto(run)));
            return runDTOs;
        }
        else {
            throw new NotFoundException("No Athlete found with ID: " + oid);
        }
    }

    public RunSessionDTO fetchRun(UUID oid) {
        Optional<RunSession> run = runRepository.findById(oid);
        if(run.isPresent()){

            return RecordMapper.toDto(run.get());
        }
        else {
            throw new NotFoundException("No Run found with ID: " + oid);
        }
    }

    public RunSessionDTO saveAthleteRun(UUID athleteId, RunExerciseModel runEntity) {
        RecordValidation.validate(athleteId);
        RunSession run = runFactory.createRun(athleteId, runEntity);
        runRepository.save(run);
        return RecordMapper.toDto(run);

    }

//    public RunSessionDTO updateRun(UUID oid, RunExerciseEntity runEntity) {
//
//        Optional<RunSession> optionalRun = runRepository.findById(oid);
//        if(optionalRun.isPresent()){
//            RunSession run = optionalRun.get();
//
//            run.updateRun(runEntity.getScheduledDateTime(), runEntity.getActualDateTime(), runEntity.getDurationMinutes(), runEntity.getCaloriesBurned(), runEntity.getIntensityLevel(),runEntity.getMaxHeartRate(), runEntity.getTrainingFocus(), runEntity.getPerceivedEffort(), runEntity.getSessionRating(), runEntity.getSorenessLevel(), runEntity.isCompleted(), runEntity.getLocation(), runEntity.getSessionNotes(), runEntity.getDistanceInKMs(), runEntity.getEquipmentUsed(), runEntity.getKmPerLap(),
//                    runEntity.getLapsCompleted());
//            runRepository.save(run);
//
//            return RecordMapper.toDto(run);
//        }
//        else {
//            throw new NoMemberFoundException("No Run found with ID: " + oid);
//        }
//    }

    public void deleteRun(UUID oid) {

        runRepository.deleteById(oid);

    }
}
