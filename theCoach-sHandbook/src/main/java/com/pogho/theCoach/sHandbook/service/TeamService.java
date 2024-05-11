package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Team;
import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.AthleteFactory;
import com.pogho.theCoach.sHandbook.factory.TeamFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import com.pogho.theCoach.sHandbook.repository.AthleteRepository;
import com.pogho.theCoach.sHandbook.repository.TeamRepository;
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
public class TeamService {

    @Autowired
    private TeamRepository repository;

    @Autowired
    private AthleteRepository athleteRepository;

    private final TeamFactory factory = new TeamFactory();
    private final AthleteFactory athleteFactory = new AthleteFactory();

    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

    /**
     * Fetches the list of all the Teams.
     */
    public List<TeamDTO> fetchTeamsList() {
        List<Team> teams = repository.findAll();
//        List<TeamDTO> teamDTOS = new ArrayList<>();
//        teams.forEach(team-> teamDTOS.add( mapper.modelToDto(team)));
        return teams.stream().map(mapper::modelToDto).toList();

    }

    /**
     * Fetches a Team given team id.
     */
    public TeamDTO fetchTeam(UUID id) {
        Optional<Team> optionalTeam = repository.findById(id);
        //if optional user exists get user, else return not found.
        if(optionalTeam.isPresent()){
            return mapper.modelToDto(optionalTeam.get());
        }
        else {
            throw new NotFoundException("No Team found with ID: " + id);
        }
    }

    public TeamDTO addTeam(@NotNull TeamModel model) {
        MemberValidation.validate(model.getName());
        Team team = factory.createTeam(model);
        repository.save(team);

        return mapper.modelToDto(team);


    }

    public TeamDTO updateTeam(UUID id, @NotNull TeamModel model) {

        MemberValidation.validate(model.getName());

        Optional<Team> optionalTeam = repository.findById(id);
        if(optionalTeam.isPresent()){
            Team team = optionalTeam.get();

            team.updateTeam(model.getName(), model.getSport());
            repository.save(team);

            return mapper.modelToDto(team);
        }
        else {
            throw new NotFoundException("No Team found with ID: " + id);
        }
    }

    public void deleteTeam(UUID id) {

        repository.deleteById(id);

    }

    public List<AthleteDTO> fetchTeamAthletes(UUID teamId) {

//        List<Athlete> athletes = athleteRepository.findByTeamID(teamId);
//        return athletes.stream().map(mapper::modelToDto).toList();
        return new ArrayList<>();

    }

    public AthleteDTO saveAthlete(UUID oid, AthleteModel model) {
        MemberValidation.validate(model.getFirstName());
        Athlete athlete = athleteFactory.createAthlete(model);
        athleteRepository.save(athlete);
        return MemberMapper.toDto(athlete);
    }
}
