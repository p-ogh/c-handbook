package com.pogho.theCoach.sHandbook.factory;

import com.pogho.theCoach.sHandbook.DAO.Season;
import com.pogho.theCoach.sHandbook.models.SeasonModel;

import java.util.UUID;

public class SeasonFactory {

    public Season createSeason(SeasonModel model) {

        return new Season(UUID.randomUUID(), model.getName(), model.getStartDate(), model.getEndDate());
    }
}
