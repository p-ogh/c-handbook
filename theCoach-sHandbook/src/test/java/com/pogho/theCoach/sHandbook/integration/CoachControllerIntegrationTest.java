package com.pogho.theCoach.sHandbook.integration;

import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoUserFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoachControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPostCoach(){
        CoachEntity coachEntity = new CoachEntity("firstName", "lastName", 35, "M", "manager", "Spanish", new Date(), "active", 10 );
        ResponseEntity<CoachDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/coaches/coach", coachEntity, CoachDTO.class);
        assertEquals(coachEntity.getFirstName(), responseEntity.getBody().getFirstName());
    }

    @Test
    public void testGetCoachWithCorrectID(){
        CoachEntity coachEntity = new CoachEntity("firstName", "lastName", 35, "M", "manager", "Spanish", new Date(), "active", 10 );
        ResponseEntity<CoachDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/coaches/coach", coachEntity, CoachDTO.class);
        ResponseEntity<CoachDTO> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/coaches/coach/"+ responseEntity.getBody().getId(), CoachDTO.class);


        assertEquals(coachEntity.getFirstName(), getResponseEntity.getBody().getFirstName());
    }

    @Test
    public void testGetCoachWithWrongID(){
        UUID randomUUID = UUID.randomUUID();
        ResponseEntity<String> getResponseEntity =  restTemplate.getForEntity("http://localhost:" + port+ "/coaches/coach/"+ randomUUID, String.class);
        System.out.println(getResponseEntity.getBody());
        assertEquals("No Coach found with ID: " + randomUUID, getResponseEntity.getBody());
    }
}
