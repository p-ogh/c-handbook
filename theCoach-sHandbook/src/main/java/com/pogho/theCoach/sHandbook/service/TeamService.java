package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Team;
import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.TeamFactory;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import com.pogho.theCoach.sHandbook.repository.TeamRepository;
import com.pogho.theCoach.sHandbook.validations.RecordValidation;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    private final TeamFactory factory = new TeamFactory();

    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

    /**
     * Fetches the list of all  Teams.
     */
    public List<TeamDTO> fetchTeamsList() {
        List<Team> teams = repository.findAll();
//        List<TeamDTO> teamDTOS = new ArrayList<>();
//        teams.forEach(teamID-> teamDTOS.add( mapper.modelToDto(teamID)));
        return teams.stream().map(mapper::modelToDto).toList();

    }

    /**
     * Fetches a Team given teamID id.
     */
    public TeamDTO fetchTeam(UUID id) {
        Optional<Team> optionalTeam = repository.findById(id);
        //if optional team exists get team, else return not found.
        if(optionalTeam.isPresent()){
            return mapper.modelToDto(optionalTeam.get());
        }
        else {
            throw new NotFoundException("No Team found with ID: " + id);
        }
    }
    /**
     * Adds a new Team with given team model.
     */
    public TeamDTO addTeam(@NotNull TeamModel model) {
        RecordValidation.validate(model.getName());
        Team team = factory.createTeam(model);
        repository.save(team);

        return mapper.modelToDto(team);

    }

    /**
     * Updates Team with team_id with the given model.
     */
    public TeamDTO updateTeam(UUID id, @NotNull TeamModel model) {

        RecordValidation.validate(model.getName());

        Optional<Team> optionalTeam = repository.findById(id);
        if(optionalTeam.isPresent()){
            Team team = optionalTeam.get();

            team.updateTeam(model.getName(), model.getSport(), model.getSeasons());
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


//    public AthleteDTO saveAthlete(UUID oid, AthleteModel model) {
//        MemberValidation.validate(model.getFirstName());
//        Athlete athlete = athleteFactory.createAthlete(model);
//        athleteRepository.save(athlete);
//        return MemberMapper.toDto(athlete);
//    }
}
