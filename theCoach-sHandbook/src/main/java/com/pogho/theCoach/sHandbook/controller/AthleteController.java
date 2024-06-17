package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.AthleteDTO;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
import com.pogho.theCoach.sHandbook.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/athletes")
@RestController
public class AthleteController {
    @Autowired
    private AthleteService service;

    //getUsers
    @GetMapping("all")
    public ResponseEntity<List<AthleteDTO>> fetchAthletesList()
    {
        return new ResponseEntity<>(service.fetchAthletesList(), HttpStatus.OK);

    }
    //getUsers
    @GetMapping("teamID/{id}/athlete")
    public ResponseEntity<List<AthleteDTO>> fetchTeamAthletes(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchTeamAthletes(id), HttpStatus.OK);

    }

    //getUser
    @GetMapping("athlete/{oid}")
    public ResponseEntity<AthleteDTO> fetchAthlete(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(service.fetchAthlete(oid), HttpStatus.OK);

    }

    //addUser
    @PostMapping("athlete")
    public ResponseEntity<AthleteDTO> saveAthlete(@RequestBody AthleteModel athleteEntity) {

        return new ResponseEntity<>(service.saveAthlete(athleteEntity), HttpStatus.CREATED);

    }


    //updateUser
    @PutMapping("athlete/{oid}")
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable("oid")UUID oid, @RequestBody AthleteModel athleteEntity)
    {
        return new ResponseEntity<>(service.updateAthlete(oid, athleteEntity), HttpStatus.OK);
    }


    //updateUser
    @DeleteMapping("athlete/{oid}")
    public ResponseEntity<HttpStatusCode> deleteAthlete(@PathVariable("oid")UUID oid)
    {
        service.deleteAthlete(oid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
