package com.pogho.theCoach.sHandbook.unit;

import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.repository.AthleteRepository;
import com.pogho.theCoach.sHandbook.service.AthleteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AthleteServiceUnitTest {

    @InjectMocks
    public AthleteService athleteService;

    @Mock//Could not use @InjectMocks here because CoachRepository is an interface
    public AthleteRepository athleteRepository;

    @Test
    public void AthleteCreatedWithNoNameFails() {
        UUID teamId = UUID.randomUUID();
        AthleteModel athleteEntity = new AthleteModel("", "lastName", 38, "M", "manager", new ArrayList<>(), new Date(), "active", 19, 173, 87, "available"  );
        Assertions.assertThrows(NoNameException.class, () -> {
            athleteService.saveAthlete(teamId,athleteEntity);
        });
    }

    @Test
    public void AthleteCreatedWithNamePasses() {
        UUID teamId = UUID.randomUUID();
        AthleteModel athleteEntity = new AthleteModel("Tega", "OG", 38, "M", "manager", new ArrayList<>(), new Date(), "active", 19, 173, 87, "available"  );
        AthleteDTO athleteDTO =   athleteService.saveAthlete(teamId,athleteEntity);
        Assertions.assertNotNull(athleteDTO.getId());
        assertEquals(athleteDTO.getFirstName(), athleteEntity.getFirstName());
        assertEquals(athleteDTO.getLastName(), athleteEntity.getLastName());
        assertEquals(athleteDTO.getRole(), athleteEntity.getRole());
    }
}
