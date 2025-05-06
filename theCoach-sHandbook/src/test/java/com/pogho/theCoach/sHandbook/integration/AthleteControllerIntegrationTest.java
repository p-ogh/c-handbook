package com.pogho.theCoach.sHandbook.integration;

import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.ErrorDTO;
import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AthleteControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPostAthlete(){
        TeamModel teamModel = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", teamModel, TeamDTO.class);
        UUID teamId = teamDTOResponseEntity.getBody().getId();
        AthleteModel model = new AthleteModel("Tega", "OG",  38, "M", "player", new ArrayList<>(), new Date(), "active",  19, 173, 87, "available"  );
        ResponseEntity<AthleteDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/athletes/team/"+ teamId + "/add", model, AthleteDTO.class);
        assertEquals(model.getFirstName(), responseEntity.getBody().getFirstName());
    }

    @Test
    public void testPostAthleteNoName(){
        TeamModel teamModel = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", teamModel, TeamDTO.class);
        UUID teamId = teamDTOResponseEntity.getBody().getId();

        AthleteModel model = new AthleteModel("", "OG",  38, "M", "player", new ArrayList<>(), new Date(), "active",  19, 173, 87, "available"  );
        ResponseEntity<ErrorDTO>  responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/athletes/team/"+ teamId + "/add", model, ErrorDTO.class);
        assertEquals("First Name cannot be empty or null.", responseEntity.getBody().getMessage());
    }
    @Test
    public void testGetAthleteWithCorrectID(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);
        UUID teamId = teamDTOResponseEntity.getBody().getId();

        AthleteModel athleteEntity = new AthleteModel("Tega", "OG", 38, "M", "manager", new ArrayList<>(), new Date(), "active", 19, 173, 87, "available"  );
        ResponseEntity<AthleteDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/athletes/team/"+ teamId + "/add", athleteEntity, AthleteDTO.class);
        ResponseEntity<AthleteDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/athletes/athlete/"+ responseEntity.getBody().getId(), AthleteDTO.class);

        assertEquals(athleteEntity.getFirstName(), getResponseEntity.getBody().getFirstName());
    }

    @Test
    public void testGetCoachWithWrongID(){
        UUID randomUUID = UUID.randomUUID();
        ResponseEntity<ErrorDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/athletes/athlete/"+ randomUUID, ErrorDTO.class);
        System.out.println(getResponseEntity.getBody());
        assertEquals("No Athlete found with ID: " + randomUUID, getResponseEntity.getBody().getMessage());
    }
}
