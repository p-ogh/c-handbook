package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.RunSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RunRepository extends JpaRepository<RunSession, UUID> {

    @Query("SELECT id, athlete_id, created date,\n" +
            "  scheduled_date_time, actual_date_time, \n" +
            "  duration_minutes, calories_burned,\n" +
            "  intensity_level, max_heart_rate,\n" +
            "  training_focus, perceived_effort,\n" +
            "  session_rating, soreness_level,\n" +
            "  completed, location, session_notes,\n" +
            "  distance_kms, equipment_used, km_per_lap,\n" +
            "  laps_completed, avg_speed FROM run_session where athlete_id = ?")
    List<RunSession> findAllRuns(UUID oid);
}
