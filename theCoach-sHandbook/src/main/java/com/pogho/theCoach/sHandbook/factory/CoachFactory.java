package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.models.CoachModel;
import com.pogho.theCoach.sHandbook.enums.Status;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CoachFactory {

    public Coach createCoach(CoachModel coachEntity) {

        return new Coach(UUID.randomUUID(), coachEntity.getFirstName(),coachEntity.getLastName(), coachEntity.getAge(), coachEntity.getGender(), coachEntity.getRole(),coachEntity.getNationality(), new Date(), Status.active.toString(), coachEntity.getYearsOfExperience());
    }
}
