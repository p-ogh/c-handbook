package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.RunSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RunRepository extends JpaRepository<RunSession, UUID> {

    @Query(value = """
            SELECT id, athlete_id, created,
              scheduled_date_time, actual_date_time,
              duration_minutes, calories_burned,
              intensity_level, max_heart_rate,
              training_focus, perceived_effort,
              session_rating, soreness_level,
              completed, location, session_notes,
              distance_kms, equipment_used, km_per_lap,
              laps_completed, avg_speed FROM run_session where athlete_id = ?1""", nativeQuery = true)
    List<RunSession> findAllRuns(UUID oid);
}
