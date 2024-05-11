package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {

//    @Query(value = """
//            SELECT id, athlete_id, created,
//              scheduled_date_time, actual_date_time,
//              duration_minutes, calories_burned,
//              intensity_level, max_heart_rate,
//              training_focus, perceived_effort,
//              session_rating, soreness_level,
//              completed, location, session_notes,
//              distance_kms, equipment_used, km_per_lap,
//              laps_completed, avg_speed FROM run_session where athlete_id = ?1""", nativeQuery = true)
//    List<Session> findAllSessions(UUID oid);
}
