package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.enums.Status;

import java.util.Date;
import java.util.UUID;

public class AthleteFactory {

    public Athlete createAthlete(AthleteModel athleteModel) {

        return new Athlete(UUID.randomUUID(), athleteModel.getFirstName(),athleteModel.getLastName(), athleteModel.getAge(), athleteModel.getGender(), athleteModel.getRole(),athleteModel.getNationality(), new Date(), Status.active.toString(), athleteModel.getJerseyNumber(), athleteModel.getHeight(), athleteModel.getWeight(), athleteModel.getAvailability());
    }
}
