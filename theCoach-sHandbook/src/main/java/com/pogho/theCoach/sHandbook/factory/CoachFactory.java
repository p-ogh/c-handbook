package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.models.CoachModel;
import com.pogho.theCoach.sHandbook.enums.Status;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CoachFactory {

    public Coach createCoach(UUID teamId, CoachModel model) {

        return new Coach(UUID.randomUUID(), model.getFirstName(),model.getLastName(), teamId, model.getAge(), model.getGender(), model.getRole(),model.getSeasons(), new Date(), Status.active.toString(), model.getYearsOfExperience());
    }
}
