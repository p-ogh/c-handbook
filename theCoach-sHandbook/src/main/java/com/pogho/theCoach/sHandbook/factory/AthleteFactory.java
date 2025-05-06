package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.enums.Status;

import java.util.Date;
import java.util.UUID;

public class AthleteFactory {

    public Athlete createAthlete(UUID teamId, AthleteModel model) {

        return new Athlete(UUID.randomUUID(), model.getFirstName(),model.getLastName(), teamId, model.getAge(), model.getGender(), model.getRole(),model.getSeasons(), new Date(), Status.active.toString(), model.getJerseyNumber(), model.getHeight(), model.getWeight(), model.getAvailability());
    }
}
