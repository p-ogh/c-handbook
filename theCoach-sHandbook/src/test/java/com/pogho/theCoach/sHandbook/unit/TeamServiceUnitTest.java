package com.pogho.theCoach.sHandbook.unit;

import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import com.pogho.theCoach.sHandbook.repository.TeamRepository;
import com.pogho.theCoach.sHandbook.service.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TeamServiceUnitTest {

    @InjectMocks
    public TeamService service;

    @Mock//Could not use @InjectMocks here because CoachRepository is an interface
    public TeamRepository repository;



    @Test
    public void TeamCreatedWithNoNameFails() {
        TeamModel model = new TeamModel("", "Soccer", new ArrayList<>());
        Assertions.assertThrows(NoNameException.class, () -> {
            service.addTeam(model);
        });
    }

    @Test
    public void TeamCreatedWithNamePasses() {
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        TeamDTO teamDTO =   service.addTeam(model);
        Assertions.assertNotNull(teamDTO.getId());
        assertEquals(teamDTO.getName(), model.getName());
        assertEquals(teamDTO.getSport(), model.getSport());
        assertEquals(teamDTO.getSeasons(), model.getSeasons());
    }

//    @Test
//    public void TeamUpdatedWithNamePasses() {
//        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
//        TeamDTO teamDTO =   service.addTeam(model);
//        System.out.println(teamDTO.getId());
//        TeamModel updateModel = new TeamModel("Team 2", "Basketball", new ArrayList<>());
//
//        teamDTO = service.updateTeam(teamDTO.getId(), updateModel);
//        Assertions.assertNotNull(teamDTO.getId());
//        assertEquals(teamDTO.getName(), updateModel.getName());
//        assertEquals(teamDTO.getSport(), updateModel.getSport());
//        assertEquals(teamDTO.getSeasons(), updateModel.getSeasons());
//    }


}
