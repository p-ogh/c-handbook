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
public class CoachControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPostCoach(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);

        CoachModel coachEntity = new CoachModel("firstName", "lastName", teamDTOResponseEntity.getBody().getId(), 35, "M", "manager", new ArrayList<>(), new Date(), "active", 10 );
        ResponseEntity<CoachDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/coaches/coach", coachEntity, CoachDTO.class);
        assertEquals(coachEntity.getFirstName(), responseEntity.getBody().getFirstName());
    }


    @Test
    public void testPostCoachNoName(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);

        CoachModel coachEntity = new CoachModel("", "lastName", teamDTOResponseEntity.getBody().getId(), 35, "M", "manager", new ArrayList<>(), new Date(), "active", 10 );
        ResponseEntity<ErrorDTO>  responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/coaches/coach", coachEntity, ErrorDTO.class);
        assertEquals("First Name cannot be empty or null.", responseEntity.getBody().getMessage());
    }

    @Test
    public void testGetCoachWithCorrectID(){
        TeamModel model = new TeamModel("Team 1", "Soccer", new ArrayList<>());
        ResponseEntity<TeamDTO> teamDTOResponseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/teams/team", model, TeamDTO.class);
        CoachModel coachModel = new CoachModel("firstName", "lastName", Objects.requireNonNull(teamDTOResponseEntity.getBody()).getId(), 35, "M", "manager", new ArrayList<>(), new Date(), "active", 10 );
        ResponseEntity<CoachDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/coaches/coach", coachModel, CoachDTO.class);
        ResponseEntity<CoachDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/coaches/coach/"+ responseEntity.getBody().getId(), CoachDTO.class);


        assertEquals(coachModel.getFirstName(), getResponseEntity.getBody().getFirstName());
    }

    @Test
    public void testGetCoachWithWrongID(){
        UUID randomUUID = UUID.randomUUID();
        ResponseEntity<ErrorDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/coaches/coach/"+ randomUUID, ErrorDTO.class);
        System.out.println(getResponseEntity.getBody());
        assertEquals("No Coach found with ID: " + randomUUID, getResponseEntity.getBody().getMessage());
    }
}
