package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.MatchSession;
import com.pogho.theCoach.sHandbook.DAO.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchSessionRepository extends JpaRepository<MatchSession, UUID> {


}
