package com.pogho.theCoach.sHandbook.validations;

import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;

import java.util.UUID;

public class RecordValidation {

//    public static void validate(RecordEntity record){
//        validate(record.getAthleteId());
//    }

    public static void validate(UUID athleteId){
        if(athleteId == null){
            throw new NotFoundException("Athlete ID cannot be empty or null.");
        }
    }
}
