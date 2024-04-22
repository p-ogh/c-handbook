package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoMemberFoundException;
import com.pogho.theCoach.sHandbook.factory.CoachFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.repository.CoachRepository;
import com.pogho.theCoach.sHandbook.validations.MemberValidation;
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
    private CoachFactory coachFactory = new CoachFactory();


    public List<CoachDTO> fetchCoachsList() {
        List<Coach> coaches = coachRepository.findAll();
        List<CoachDTO> coachDTOS = new ArrayList<>();
        coaches.forEach(coach-> coachDTOS.add(MemberMapper.toDto(coach)));
        return coachDTOS;
    }

    public CoachDTO fetchCoach(UUID oid) {
        Optional<Coach> optionalCoach = coachRepository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalCoach.isPresent()){
            CoachDTO coachDTO =  MemberMapper.toDto(optionalCoach.get());
            return coachDTO;
        }
        else {
            throw new NoMemberFoundException("No Coach found with ID: " + oid);
        }
    }

    public CoachDTO saveCoach(CoachEntity coachEntity) {
        //go to coachfactory, verify property firstname exists,create coach, return coach, save coach in repository,return coachdto
        MemberValidation.validate(coachEntity.getFirstName());
        Coach coach = coachFactory.createCoach(coachEntity);
        coachRepository.save(coach);
        CoachDTO coachDTO =  MemberMapper.toDto(coach);
        return coachDTO;

    }

    public CoachDTO updateCoach(UUID oid, CoachEntity coachEntity) {

        MemberValidation.validate(coachEntity.getFirstName());

        Optional<Coach> optionalCoach = coachRepository.findById(oid);
        if(optionalCoach.isPresent()){
            Coach coach = optionalCoach.get();

            coach.updateCoach(coachEntity.getFirstName(), coachEntity.getLastName(),coachEntity.getAge(), coachEntity.getGender(), coachEntity.getRole(),coachEntity.getNationality(), coachEntity.getStatus(), coachEntity.getYearsOfExperience());
            coachRepository.save(coach);

            CoachDTO coachDTO =  MemberMapper.toDto(coach);
            return coachDTO;
        }
        else {
            throw new NoMemberFoundException("No Coach found with ID: " + oid);
        }
    }

    public void deleteCoach(UUID oid) {

        coachRepository.deleteById(oid);

    }
}
