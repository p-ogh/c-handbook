package com.pogho.theCoach.sHandbook.mapper;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;

public class MemberMapper {


    public static CoachDTO toDto(Coach coach){
        CoachDTO coachDTO = new CoachDTO(coach.getId(), coach.getFirstName(), coach.getLastName(), coach.getRole());
        return coachDTO;
    }

    public static AthleteDTO toDto(Athlete athlete){
        AthleteDTO athleteDTO = new AthleteDTO(athlete.getId(), athlete.getFirstName(), athlete.getLastName(), athlete.getRole());
        return athleteDTO;
    }

}
