package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Team;
import com.pogho.theCoach.sHandbook.enums.Status;
import com.pogho.theCoach.sHandbook.models.TeamModel;

import java.util.Date;
import java.util.UUID;

public class TeamFactory {

    public Team createTeam(TeamModel model){

        return new Team(UUID.randomUUID(), model.getName(), model.getSport(), Status.active.name(), new Date());
    }
}
