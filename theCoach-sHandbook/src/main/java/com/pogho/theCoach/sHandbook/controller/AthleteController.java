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
    private AthleteService athleteService;

    //getUsers
    @GetMapping("all")
    public ResponseEntity<List<AthleteDTO>> fetchAthletesList()
    {
        return new ResponseEntity<>(athleteService.fetchAthletesList(), HttpStatus.OK);

    }

    //getUser
    @GetMapping("athlete/{oid}")
    public ResponseEntity<AthleteDTO> fetchAthlete(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(athleteService.fetchAthlete(oid), HttpStatus.OK);

    }

    //addUser
    @PostMapping("athlete")
    public ResponseEntity<AthleteDTO> saveAthlete(@RequestBody AthleteModel athleteEntity) {

        return new ResponseEntity<>(athleteService.saveAthlete(athleteEntity), HttpStatus.CREATED);

    }


    //updateUser
    @PutMapping("athlete/{oid}")
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable("oid")UUID oid, @RequestBody AthleteModel athleteEntity)
    {
        return new ResponseEntity<>(athleteService.updateAthlete(oid, athleteEntity), HttpStatus.OK);
    }


    //updateUser
    @DeleteMapping("athlete/{oid}")
    public ResponseEntity<HttpStatusCode> deleteAthlete(@PathVariable("oid")UUID oid)
    {
        athleteService.deleteAthlete(oid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
