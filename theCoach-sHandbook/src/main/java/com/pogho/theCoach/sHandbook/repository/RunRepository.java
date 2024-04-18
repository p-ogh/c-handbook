package com.pogho.theCoach.sHandbook.repository;

import com.pogho.theCoach.sHandbook.DAO.Athlete;
import com.pogho.theCoach.sHandbook.DAO.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AthleteRepository extends JpaRepository<Athlete, UUID> {

//    @Query("SELECT id,first_name,last_name, age, gender, role, nationality, date_added, status FROM Member")
//    List<Member> findMembers();
}
