package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.AthleteFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.repository.AthleteRepository;
import com.pogho.theCoach.sHandbook.validations.MemberValidation;
import org.mapstruct.factory.Mappers;
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
    private final AthleteFactory athleteFactory = new AthleteFactory();
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);


    public List<AthleteDTO> fetchAthletesList() {
        List<Athlete> athletes = athleteRepository.findAll();
        return  athletes.stream().map(mapper::modelToDto).toList();
    }

    public List<AthleteDTO> fetchTeamAthletes(UUID teamId) {

      List<Athlete> athletes = athleteRepository.findByTeamId(teamId);
        return athletes.stream().map(mapper::modelToDto).toList();
       // return new ArrayList<>();
    }

    public AthleteDTO fetchAthlete(UUID oid) {
        Optional<Athlete> optionalAthlete = athleteRepository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalAthlete.isPresent()){
            return MemberMapper.toDto(optionalAthlete.get());
        }
        else {
            throw new NotFoundException("No Athlete found with ID: " + oid);
        }
    }

    public AthleteDTO saveAthlete(AthleteModel athleteModel) {
        MemberValidation.validate(athleteModel.getFirstName());
        Athlete athlete = athleteFactory.createAthlete(athleteModel);
        athleteRepository.save(athlete);
        return MemberMapper.toDto(athlete);

    }

    public AthleteDTO updateAthlete(UUID oid, AthleteModel model) {

        MemberValidation.validate(model.getFirstName());

        Optional<Athlete> optionalAthlete = athleteRepository.findById(oid);
        if(optionalAthlete.isPresent()){
            Athlete athlete = optionalAthlete.get();

            athlete.updateAthlete(model.getFirstName(), model.getLastName(), model.getTeamID(), model.getAge(), model.getGender(), model.getRole(),model.getSeasons(), model.getStatus(), athlete.getJerseyNumber(), model.getHeight(), model.getWeight(), model.getAvailability());
            athleteRepository.save(athlete);

            return MemberMapper.toDto(athlete);
        }
        else {
            throw new NotFoundException("No Athlete found with ID: " + oid);
        }
    }

    public void deleteAthlete(UUID oid) {

        athleteRepository.deleteById(oid);

    }
}
