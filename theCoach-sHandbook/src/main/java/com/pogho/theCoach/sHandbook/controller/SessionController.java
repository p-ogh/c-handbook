package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.MatchSessionDTO;
import com.pogho.theCoach.sHandbook.DTO.PracticeSessionDTO;
import com.pogho.theCoach.sHandbook.DTO.SessionDTO;
import com.pogho.theCoach.sHandbook.DTO.TrainingSessionDTO;
import com.pogho.theCoach.sHandbook.models.AthleteModel;
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

    @GetMapping("all")
    public ResponseEntity<List<SessionDTO>> fetchSessions()
    {
        return new ResponseEntity<>(service.fetchSessions(), HttpStatus.OK);
    }

    @GetMapping("completed")
    public ResponseEntity<List<SessionDTO>> fetchCompletedSessions()
    {
        return new ResponseEntity<>(service.fetchSessions(), HttpStatus.OK);
    }

    @GetMapping("training")
    public ResponseEntity<List<TrainingSessionDTO>> fetchTrainingSessions()
    {
        return new ResponseEntity<>(service.fetchTrainingSessions(), HttpStatus.OK);
    }

    @GetMapping("match")
    public ResponseEntity<List<MatchSessionDTO>> fetchMatchSessions()
    {
        return new ResponseEntity<>(service.fetchMatchSessions(), HttpStatus.OK);
    }

    @GetMapping("practice")
    public ResponseEntity<List<PracticeSessionDTO>> fetchPracticeSessions()
    {
        return new ResponseEntity<>(service.fetchPracticeSessions(), HttpStatus.OK);
    }

    @PostMapping("session")
    public ResponseEntity<SessionDTO> addNewSession(@RequestBody SessionModel session)
    {
        return new ResponseEntity<>(service.addNewSession(session), HttpStatus.OK);
    }

    @PutMapping("session/{id}/start")
    public ResponseEntity<SessionDTO> startSession(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.startSession(id), HttpStatus.OK);
    }

    @PutMapping("session/{id}/end")
    public ResponseEntity<SessionDTO> endSession(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.endSession(id), HttpStatus.OK);
    }

    @PutMapping("session/{id}")
    public ResponseEntity<SessionDTO> updateSession(@PathVariable("id") UUID id, @RequestBody SessionModel model)
    {
        return new ResponseEntity<>(service.updateSession(id, model), HttpStatus.OK);
    }

}
