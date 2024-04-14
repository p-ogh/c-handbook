package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.enums.Status;

import java.util.Date;
import java.util.UUID;

public class CoachFactory {

    public Coach createCoach(CoachEntity coachEntity) {

        Coach coach = new Coach(UUID.randomUUID(), coachEntity.getFirstName(),coachEntity.getLastName(), coachEntity.getAge(), coachEntity.getGender(), coachEntity.getRole(),coachEntity.getNationality(), new Date(), Status.active.toString(), coachEntity.getYearsOfExperience());
        return coach;
    }
}
