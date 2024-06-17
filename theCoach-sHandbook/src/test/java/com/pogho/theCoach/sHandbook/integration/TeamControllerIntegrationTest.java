package com.pogho.theCoach.sHandbook.integration;

import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.DTO.ErrorDTO;
import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.models.CoachModel;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPostTeamWithCorrectDetails(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);
        assertEquals(model.getName(), Objects.requireNonNull(responseEntity.getBody()).getName());
    }

    @Test
    public void testPostTeamNoName(){
        TeamModel model = new TeamModel("", "Soccer", new ArrayList<>());

        ResponseEntity<ErrorDTO> getResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, ErrorDTO.class);

        assertEquals("Name cannot be empty or null.", getResponseEntity.getBody().getMessage());
    }

    @Test
    public void testGetTeamWithCorrectID(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);
        System.out.println(responseEntity.getBody());


        ResponseEntity<TeamDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/teams/team/"+ responseEntity.getBody().getId(), TeamDTO.class);


        assertEquals(model.getName(), getResponseEntity.getBody().getName());
    }

    @Test
    public void testGetTeamWithWrongID(){
        UUID randomUUID = UUID.randomUUID();
        ResponseEntity<ErrorDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/teams/team/"+ randomUUID, ErrorDTO.class);
        System.out.println(getResponseEntity.getBody());
        assertEquals("No Team found with ID: " + randomUUID, getResponseEntity.getBody().getMessage());
    }
}
