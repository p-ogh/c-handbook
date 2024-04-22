package com.pogho.theCoach.sHandbook.mapper;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DAO.RunSession;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.DTO.RunSessionDTO;

public class RecordMapper {


    public static RunSessionDTO toDto(RunSession run){
        RunSessionDTO runDTO = new RunSessionDTO(run.getId(), run.getAthleteId(), run.getCreated(), run.getScheduledDateTime(), run.getActualDateTime(), run.getDurationMinutes(), run.getCaloriesBurned(), run.getIntensityLevel(), run.getMaxHeartRate(), run.getTrainingFocus(), run.getPerceivedEffort(), run.getSessionRating(), run.getSorenessLevel(), run.getCompleted(), run.getLocation(), run.getSessionNotes(), run.getDistanceInKMs(), run.getEquipmentUsed(), run.getKmPerLap(), run.getLapsCompleted(), run.getAvgSpeed()  ;
        return runDTO;
    }


}
