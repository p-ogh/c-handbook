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

    @GetMapping("all")
    public ResponseEntity<List<AthleteDTO>> fetchAthletesList()
    {
        return new ResponseEntity<>(service.fetchAthletesList(), HttpStatus.OK);
    }

    @GetMapping("team/{id}")
    public ResponseEntity<List<AthleteDTO>> fetchTeamAthletes(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchTeamAthletes(id), HttpStatus.OK);
    }

    @GetMapping("athlete/{id}")
    public ResponseEntity<AthleteDTO> fetchAthlete(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchAthlete(id), HttpStatus.OK);
    }

    @PostMapping("team/{id}")
    public ResponseEntity<AthleteDTO> saveAthlete(@PathVariable("id") UUID id, @RequestBody AthleteModel athlete) {

        return new ResponseEntity<>(service.saveAthlete(id, athlete), HttpStatus.CREATED);
    }

    @PutMapping("athlete/{oid}")
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable("oid")UUID oid, @RequestBody AthleteModel athlete)
    {
        return new ResponseEntity<>(service.updateAthlete(oid, athlete), HttpStatus.OK);
    }


    @DeleteMapping("athlete/{oid}")
    public ResponseEntity<HttpStatusCode> deleteAthlete(@PathVariable("oid")UUID oid)
    {
        service.deleteAthlete(oid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
