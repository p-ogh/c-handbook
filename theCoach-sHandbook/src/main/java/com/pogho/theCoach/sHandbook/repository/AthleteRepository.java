package com.pogho.theCoach.sHandbook.repository;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AthleteRepository extends JpaRepository<Athlete, UUID> {


 //@Query("SELECT COUNT(*) FROM athlete where team_id=?1")
 List<Athlete> findByTeamId(UUID team_id);

 int countByTeamId(UUID team_id);


}
