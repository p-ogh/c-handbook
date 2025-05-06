package com.pogho.theCoach.sHandbook.unit;

import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.models.CoachModel;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.repository.CoachRepository;
import com.pogho.theCoach.sHandbook.service.CoachService;
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
public class CoachServiceUnitTest {

    @InjectMocks
    public CoachService coachService;

    @Mock//Could not use @InjectMocks here because CoachRepository is an interface
    public CoachRepository coachRepository;



    @Test
    public void CoachCreatedWithNoNameFails() {
        UUID teamId = UUID.randomUUID();
        CoachModel model = new CoachModel("", "lastName", 35, "M", "manager", new ArrayList<>(), new Date(), "active", 10 );
        Assertions.assertThrows(NoNameException.class, () -> {
            coachService.saveCoach(teamId,model);
        });
    }

    @Test
    public void CoachCreatedWithNamePasses() {
        UUID teamId = UUID.randomUUID();

        CoachModel coachModel = new CoachModel("firstName", "lastName", 38, "M", "manager", new ArrayList<>(), new Date(), "active", 10 );
        CoachDTO coachDTO =   coachService.saveCoach(teamId,coachModel);
        Assertions.assertNotNull(coachDTO.getId());
        assertEquals(coachDTO.getFirstName(), coachModel.getFirstName());
        assertEquals(coachDTO.getLastName(), coachModel.getLastName());
        assertEquals(coachDTO.getRole(), coachModel.getRole());
    }
}
