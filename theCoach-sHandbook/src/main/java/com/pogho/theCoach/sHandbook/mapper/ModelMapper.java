package com.pogho.theCoach.sHandbook.mapper;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DAO.Session;
import com.pogho.theCoach.sHandbook.DAO.Team;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.DTO.SessionDTO;
import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
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

    Session dtoToModel(SessionDTO sessionDTO);
    SessionDTO modelToDto(Session session);

    Team dtoToModel(TeamDTO teamDTO);
    TeamDTO modelToDto(Team team);

    Athlete dtoToModel(AthleteDTO athleteDTO);
    AthleteDTO modelToDto(Athlete athlete);
}
