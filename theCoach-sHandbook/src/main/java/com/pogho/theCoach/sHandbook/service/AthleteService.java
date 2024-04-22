package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.entities.AthleteEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoMemberFoundException;
import com.pogho.theCoach.sHandbook.factory.AthleteFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.repository.AthleteRepository;
import com.pogho.theCoach.sHandbook.validations.MemberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;
    private AthleteFactory athleteFactory = new AthleteFactory();


    public List<AthleteDTO> fetchAthletesList() {
        List<Athlete> athletes = athleteRepository.findAll();
        List<AthleteDTO> athleteDTOs = new ArrayList<>();
        athletes.forEach(athlete-> athleteDTOs.add(MemberMapper.toDto(athlete)));
        return athleteDTOs;
    }

    public AthleteDTO fetchAthlete(UUID oid) {
        Optional<Athlete> optionalAthlete = athleteRepository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalAthlete.isPresent()){
            AthleteDTO athleteDTO =  MemberMapper.toDto(optionalAthlete.get());
            return athleteDTO;
        }
        else {
            throw new NoMemberFoundException("No Athlete found with ID: " + oid);
        }
    }

    public AthleteDTO saveAthlete(AthleteEntity athleteEntity) {
        MemberValidation.validate(athleteEntity.getFirstName());
        Athlete athlete = athleteFactory.createAthlete(athleteEntity);
        athleteRepository.save(athlete);
        AthleteDTO athleteDTO =  MemberMapper.toDto(athlete);
        return athleteDTO;

    }

    public AthleteDTO updateAthlete(UUID oid, AthleteEntity athleteEntity) {

        MemberValidation.validate(athleteEntity.getFirstName());

        Optional<Athlete> optionalAthlete = athleteRepository.findById(oid);
        if(optionalAthlete.isPresent()){
            Athlete athlete = optionalAthlete.get();

            athlete.updateAthlete(athleteEntity.getFirstName(), athleteEntity.getLastName(),athleteEntity.getAge(), athleteEntity.getGender(), athleteEntity.getRole(),athleteEntity.getNationality(), athleteEntity.getStatus(), athleteEntity.getSport(), athlete.getJerseyNumber(), athleteEntity.getHeight(), athleteEntity.getWeight(), athleteEntity.getAvailability());
            athleteRepository.save(athlete);

            AthleteDTO athleteDTO =  MemberMapper.toDto(athlete);
            return athleteDTO;
        }
        else {
            throw new NoMemberFoundException("No Athlete found with ID: " + oid);
        }
    }

    public void deleteAthlete(UUID oid) {

        athleteRepository.deleteById(oid);

    }
}
