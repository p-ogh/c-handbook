package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.Exercise;
import com.pogho.theCoach.sHandbook.DAO.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

}
