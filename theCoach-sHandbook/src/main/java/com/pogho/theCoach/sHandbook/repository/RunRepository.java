package com.pogho.theCoach.sHandbook.repository;


import com.pogho.theCoach.sHandbook.DAO.Run;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RunRepository extends JpaRepository<Run, UUID> {


}
