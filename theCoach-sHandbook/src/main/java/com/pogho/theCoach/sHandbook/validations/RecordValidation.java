package com.pogho.theCoach.sHandbook.validations;

import com.pogho.theCoach.sHandbook.entities.RecordEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoMemberFoundException;

import java.util.UUID;

public class RecordValidation {

    public static void validate(RecordEntity record){
        validate(record.getAthleteId());
    }

    public static void validate(UUID athleteId){
        if(athleteId == null){
            throw new NoMemberFoundException("Athlete ID cannot be empty or null.");
        }
    }
}
