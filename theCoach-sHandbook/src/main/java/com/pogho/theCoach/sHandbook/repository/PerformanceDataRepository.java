package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.PerformanceData;
import com.pogho.theCoach.sHandbook.DAO.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PerformanceDataRepository extends JpaRepository<PerformanceData, UUID> {


    List<PerformanceData> findBySessionId(UUID sessionId);
    List<PerformanceData> findByAthleteId(UUID athleteId);

    List<PerformanceData> findByAthleteIdAndSessionType(UUID athleteId, String sessionType);
}
