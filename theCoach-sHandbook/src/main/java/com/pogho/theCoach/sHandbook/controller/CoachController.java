package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DAO.Member;
import com.pogho.theCoach.sHandbook.DTO.CoachDTO;
import com.pogho.theCoach.sHandbook.DTO.MemberDTO;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.entities.MemberEntity;
import com.pogho.theCoach.sHandbook.exceptions.NoNameException;
import com.pogho.theCoach.sHandbook.exceptions.NoUserFoundException;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.service.CoachService;
import com.pogho.theCoach.sHandbook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequestMapping("coaches")
@RestController
public class CoachController {
    @Autowired
    private CoachService coachService;

    //getUsers
    @GetMapping("all")
    public ResponseEntity<List<CoachDTO>> fetchCoachsList()
    {
        return new ResponseEntity<>(coachService.fetchCoachsList(), HttpStatus.OK);

    }

    //getUser
    @GetMapping("coach/{oid}")
    public ResponseEntity<CoachDTO> fetchCoach(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(coachService.fetchCoach(oid), HttpStatus.OK);

    }

    //addUser
    @PostMapping("coach")
    public ResponseEntity<CoachDTO> saveCoach(@RequestBody CoachEntity coachEntity) {

        return new ResponseEntity<>(coachService.saveCoach(coachEntity), HttpStatus.CREATED);

    }


    //updateUser
    @PutMapping("coach/{oid}")
    public ResponseEntity<CoachDTO> updateCoach(@PathVariable("oid")UUID oid, @RequestBody CoachEntity coachEntity)
    {
        return new ResponseEntity<>(coachService.updateCoach(oid, coachEntity), HttpStatus.OK);
    }


    //updateUser
    @DeleteMapping("coach/{oid}")
    public ResponseEntity deleteCoach(@PathVariable("oid")UUID oid)
    {
        coachService.deleteCoach(oid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
