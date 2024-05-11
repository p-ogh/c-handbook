package com.pogho.theCoach.sHandbook.mapper;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DAO.RunSession;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.DTO.RunSessionDTO;

public class RecordMapper {


    public static RunSessionDTO toDto(RunSession run){
        return new RunSessionDTO();
    }


}
