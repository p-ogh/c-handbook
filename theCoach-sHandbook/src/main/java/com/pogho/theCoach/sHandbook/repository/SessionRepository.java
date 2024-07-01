package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {

    int countByTeamIdAndSessionType(UUID team_id, String type);

}
