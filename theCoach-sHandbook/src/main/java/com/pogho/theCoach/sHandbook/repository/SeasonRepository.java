package com.pogho.theCoach.sHandbook.repository;

import com.pogho.theCoach.sHandbook.DAO.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {

    int countByTeamId(UUID team_id);

}
