package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.SessionDTO;
import com.pogho.theCoach.sHandbook.models.SessionModel;
import com.pogho.theCoach.sHandbook.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/sessions/")
@RestController
public class SessionController {
    @Autowired
    private SessionService service;

    //getAllRunsforAll Athletes

    @GetMapping("completed")
    public ResponseEntity<List<SessionDTO>> fetchSessions()
    {
        return new ResponseEntity<>(service.fetchSessions(), HttpStatus.OK);
    }

    @PostMapping("athlete/{athleteId}/add")
    public ResponseEntity<SessionDTO> addAthleteSession(@PathVariable("athleteId") UUID athleteId, @RequestBody SessionModel model)
    {
        return new ResponseEntity<>(service.addAthleteSession(athleteId, model), HttpStatus.CREATED);
    }
//
//    //getUsers
//    @GetMapping("athlete/{oid}/all")
//    public ResponseEntity<List<RunSessionDTO>> fetchRunsListByAthlete(@PathVariable("oid") UUID oid)
//    {
//        return new ResponseEntity<>(runService.fetchRunsListByAthlete(oid), HttpStatus.OK);
//
//    }
//
//    //getUser
//    @GetMapping("{oid}")
//    public ResponseEntity<RunSessionDTO> fetchRun(@PathVariable("oid") UUID oid)
//    {
//        return new ResponseEntity<>(runService.fetchRun(oid), HttpStatus.OK);
//
//    }
//
//    //addUser
//    @PostMapping("athlete/{oid}")
//    public ResponseEntity<RunSessionDTO> saveAthleteRun(@PathVariable("oid") UUID oid, @RequestBody RunExerciseEntity run) {
//
//        return new ResponseEntity<>(runService.saveAthleteRun(oid, run), HttpStatus.CREATED);
//
//    }


//    //updateUser
//    @PutMapping("{oid}")
//    public ResponseEntity<RunSessionDTO> updateRun(@PathVariable("oid")UUID oid, @RequestBody RunExerciseEntity run)
//    {
//        return new ResponseEntity<>(runService.updateRun(oid, run), HttpStatus.OK);
//    }


//    //updateUser
//    @DeleteMapping("athlete/{oid}")
//    public ResponseEntity<HttpStatusCode> deleteRun(@PathVariable("oid")UUID oid)
//    {
//        runService.deleteRun(oid);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
