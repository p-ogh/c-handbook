package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.models.CoachModel;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.CoachFactory;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.repository.CoachRepository;
import com.pogho.theCoach.sHandbook.validations.MemberValidation;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    private final CoachFactory coachFactory = new CoachFactory();
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

    /**
     * Fetches the list of all the Coaches.
     */
    public List<CoachDTO> fetchCoachsList() {
        List<Coach> coaches = coachRepository.findAll();
        List<CoachDTO> coachDTOS = new ArrayList<>();
        coaches.forEach(coach-> coachDTOS.add( mapper.modelToDto(coach)
));
        return coachDTOS;
    }

    public CoachDTO fetchCoach(UUID oid) {
        Optional<Coach> optionalCoach = coachRepository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalCoach.isPresent()){
            return mapper.modelToDto(optionalCoach.get());
        }
        else {
            throw new NotFoundException("No Coach found with ID: " + oid);
        }
    }

    public CoachDTO saveCoach(@NotNull CoachModel coachEntity) {
        //go to coachfactory, verify property firstname exists,create coach, return coach, save coach in repository,return coachdto
        MemberValidation.validate(coachEntity.getFirstName());
        Coach coach = coachFactory.createCoach(coachEntity);
        coachRepository.save(coach);

        return mapper.modelToDto(coach);


    }

    public CoachDTO updateCoach(UUID oid, @NotNull CoachModel coachEntity) {

        MemberValidation.validate(coachEntity.getFirstName());

        Optional<Coach> optionalCoach = coachRepository.findById(oid);
        if(optionalCoach.isPresent()){
            Coach coach = optionalCoach.get();

            coach.updateCoach(coachEntity.getFirstName(), coachEntity.getLastName(),coachEntity.getAge(), coachEntity.getGender(), coachEntity.getRole(),coachEntity.getNationality(), coachEntity.getStatus(), coachEntity.getYearsOfExperience());
            coachRepository.save(coach);

            return mapper.modelToDto(coach);
        }
        else {
            throw new NotFoundException("No Coach found with ID: " + oid);
        }
    }

    public void deleteCoach(UUID oid) {

        coachRepository.deleteById(oid);

    }
}
