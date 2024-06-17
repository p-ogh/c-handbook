package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Season;
import com.pogho.theCoach.sHandbook.DTO.SeasonDTO;
import com.pogho.theCoach.sHandbook.exceptions.NotFoundException;
import com.pogho.theCoach.sHandbook.factory.SeasonFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.mapper.ModelMapper;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.models.SeasonModel;
import com.pogho.theCoach.sHandbook.repository.SeasonRepository;
import com.pogho.theCoach.sHandbook.validations.MemberValidation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository repository;
    private final SeasonFactory factory = new SeasonFactory();
    private final ModelMapper mapper = Mappers.getMapper(ModelMapper.class);



    public List<SeasonDTO> fetchSeasonsList() {
        List<Season> seasons = repository.findAll();
        List<SeasonDTO> seasonDTOS = new ArrayList<>();
        seasons.forEach(season-> seasonDTOS.add(mapper.modelToDto(season)));
        return seasonDTOS;
    }

    public SeasonDTO fetchSeason(UUID oid) {
        Optional<Season> optionalSeason = repository.findById(oid);
        //if optional user exists get user, else return not found.
        if(optionalSeason.isPresent()){
            return mapper.modelToDto(optionalSeason.get());
        }
        else {
            throw new NotFoundException("No Seasib found with ID: " + oid);
        }
    }

    public SeasonDTO saveSeason(SeasonModel seasonModel) {
        MemberValidation.validate(seasonModel.getName());
        Season season = factory.createSeason(seasonModel);
        repository.save(season);
        return mapper.modelToDto(season);

    }

    public SeasonDTO updateSeason(UUID oid, SeasonModel seasonModel) {

        MemberValidation.validate(seasonModel.getName());

        Optional<Season> optionalSeason = repository.findById(oid);
        if(optionalSeason.isPresent()){
            Season season = optionalSeason.get();

            season.updateSeason(seasonModel.getName(), seasonModel.getStartDate(), seasonModel.getEndDate());
            repository.save(season);

            return mapper.modelToDto(season);
        }
        else {
            throw new NotFoundException("No Season found with ID: " + oid);
        }
    }

    public void deleteSeason(UUID oid) {

        repository.deleteById(oid);

    }
}
