package com.pogho.theCoach.sHandbook.mapper;

import com.pogho.theCoach.sHandbook.DAO.*;
import com.pogho.theCoach.sHandbook.DTO.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


//using this Mapper interface allows me to skip implementing a mapper class/method
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface ModelMapper {

    ModelMapper MAPPER = Mappers.getMapper(ModelMapper.class);

    //method overloading - methods with same name, but having different arguments
    Coach dtoToModel(CoachDTO coachDTO);
    CoachDTO modelToDto(Coach coach);

    Team dtoToModel(TeamDTO teamDTO);
    TeamDTO modelToDto(Team team);

    Athlete dtoToModel(AthleteDTO athleteDTO);
    AthleteDTO modelToDto(Athlete athlete);

    Season dtoToModel(SeasonDTO seasonDTO);
    SeasonDTO modelToDto(Season season);

    Session dtoToModel(SessionDTO sessionDTO);
    SessionDTO modelToDto(Session session);

    TrainingSession dtoToModel(TrainingSessionDTO sessionDTO);
    TrainingSessionDTO modelToDto(TrainingSession session);

    MatchSession dtoToModel(MatchSessionDTO sessionDTO);
    MatchSessionDTO modelToDto(MatchSession session);

    PracticeSession dtoToModel(PracticeSessionDTO sessionDTO);
    PracticeSessionDTO modelToDto(PracticeSession session);

    Run dtoToModel(RunSessionDTO sessionDTO);
    RunSessionDTO modelToDto(Run run);

    PerformanceData dtoToModel(PerformanceDataDTO dto);
    PerformanceDataDTO modelToDto(PerformanceData data);
}
