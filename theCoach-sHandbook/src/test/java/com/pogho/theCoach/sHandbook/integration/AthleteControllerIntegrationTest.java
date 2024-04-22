package com.pogho.theCoach.sHandbook.integration;

import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.ErrorDTO;
import com.pogho.theCoach.sHandbook.entities.AthleteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

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
    public void testPostCoach(){
        AthleteEntity athleteEntity = new AthleteEntity("Tega", "OG", 38, "M", "manager", "Nigerian", new Date(), "active", "N/A", 19, 173, 87, "available"  );
        ResponseEntity<AthleteDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/athletes/athlete", athleteEntity, AthleteDTO.class);
        assertEquals(athleteEntity.getFirstName(), responseEntity.getBody().getFirstName());
    }

    @Test
    public void testGetCoachWithCorrectID(){
        AthleteEntity athleteEntity = new AthleteEntity("Tega", "OG", 38, "M", "manager", "Nigerian", new Date(), "active", "N/A", 19, 173, 87, "available"  );
        ResponseEntity<AthleteDTO> responseEntity = restTemplate.postForEntity("http://localhost:" + port+ "/athletes/athlete", athleteEntity, AthleteDTO.class);
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
