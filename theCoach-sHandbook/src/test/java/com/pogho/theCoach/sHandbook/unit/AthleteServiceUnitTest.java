package com.pogho.theCoach.sHandbook.unit;

import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.repository.CoachRepository;
import com.pogho.theCoach.sHandbook.service.CoachService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CoachServiceUnitTest {

    @InjectMocks
    public CoachService coachService;

    @Mock//Could not use @InjectMocks here because CoachRepository is an interface
    public CoachRepository coachRepository;

    @Test
    public void CoachCreatedWithNoNameFails() {
        CoachEntity coachEntity = new CoachEntity("", "lastName", 35, "M", "manager", "Spanish", new Date(), "active", 10 );
        Assertions.assertThrows(NoNameException.class, () -> {
            coachService.saveCoach(coachEntity);
        });
    }

    @Test
    public void CoachCreatedWithNamePasses() {
        CoachEntity coachEntity = new CoachEntity("firstName", "lastName", 35, "M", "manager", "Spanish", new Date(), "active", 10 );
        CoachDTO coachDTO =   coachService.saveCoach(coachEntity);
        Assertions.assertNotNull(coachDTO.getId());
        assertEquals(coachDTO.getFirstName(), coachEntity.getFirstName());
        assertEquals(coachDTO.getLastName(), coachEntity.getLastName());
        assertEquals(coachDTO.getRole(), coachEntity.getRole());
    }
}
