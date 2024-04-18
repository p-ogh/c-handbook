package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.entities.AthleteEntity;
import com.pogho.theCoach.sHandbook.enums.Status;

import java.util.Date;
import java.util.UUID;

public class AthleteFactory {

    public Athlete createAthlete(AthleteEntity athleteEntity) {

        Athlete athlete = new Athlete(UUID.randomUUID(), athleteEntity.getFirstName(),athleteEntity.getLastName(), athleteEntity.getAge(), athleteEntity.getGender(), athleteEntity.getRole(),athleteEntity.getNationality(), new Date(), Status.active.toString(), athleteEntity.getSport(), athleteEntity.getJerseyNumber(), athleteEntity.getHeight(), athleteEntity.getWeight(), athleteEntity.getAvailability());
        return athlete;
    }
}
