package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.RunSessionDTO;
import com.pogho.theCoach.sHandbook.entities.RunSessionEntity;
import com.pogho.theCoach.sHandbook.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/session/run")
@RestController
public class RunSessionController {
    @Autowired
    private RunService runService;

    //getAllRunsforAll Athletes
    @GetMapping("all")
    public ResponseEntity<List<RunSessionDTO>> fetchRunsList()
    {
        return new ResponseEntity<>(runService.fetchRunsList(), HttpStatus.OK);

    }

    //getUsers
    @GetMapping("athlete/{oid}/all")
    public ResponseEntity<List<RunSessionDTO>> fetchRunsListByAthlete(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(runService.fetchRunsListByAthlete(oid), HttpStatus.OK);

    }

    //getUser
    @GetMapping("{oid}")
    public ResponseEntity<RunSessionDTO> fetchRun(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(runService.fetchRun(oid), HttpStatus.OK);

    }

    //addUser
    @PostMapping("athlete/{oid}")
    public ResponseEntity<RunSessionDTO> saveAthleteRun(@PathVariable("oid") UUID oid, @RequestBody RunSessionEntity run) {

        return new ResponseEntity<>(runService.saveAthleteRun(oid, run), HttpStatus.CREATED);

    }


    //updateUser
    @PutMapping("{oid}")
    public ResponseEntity<RunSessionDTO> updateRun(@PathVariable("oid")UUID oid, @RequestBody RunSessionEntity run)
    {
        return new ResponseEntity<>(runService.updateRun(oid, run), HttpStatus.OK);
    }


    //updateUser
    @DeleteMapping("athlete/{oid}")
    public ResponseEntity deleteRun(@PathVariable("oid")UUID oid)
    {
        runService.deleteRun(oid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
