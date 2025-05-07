package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.TeamDTO;
import com.pogho.theCoach.sHandbook.DTO.TeamSummaryDTO;
import com.pogho.theCoach.sHandbook.models.TeamModel;
import com.pogho.theCoach.sHandbook.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/teams/")
@RestController
public class TeamController {
    @Autowired
    private TeamService service;


    @GetMapping("active")
    public ResponseEntity<List<TeamDTO>> fetchSessions()
    {
        return new ResponseEntity<>(service.fetchTeamsList(), HttpStatus.OK);
    }

    @PostMapping("team")
    public ResponseEntity<TeamDTO> addTeam(@RequestBody TeamModel model)
    {
        return new ResponseEntity<>(service.addTeam(model), HttpStatus.CREATED);
    }

    @GetMapping("team/{id}")
    public ResponseEntity<TeamDTO> fetchTeam(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchTeam(id), HttpStatus.OK);
    }

    @GetMapping("team/{id}/summary")
    public ResponseEntity<TeamSummaryDTO> fetchTeamSummary(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchTeamSummary(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable("id")UUID id, @RequestBody TeamModel model)
    {
        return new ResponseEntity<>(service.updateTeam(id, model), HttpStatus.OK);
    }

    @DeleteMapping("team/{id}")
    public ResponseEntity<HttpStatusCode> deleteTeam(@PathVariable("id")UUID id)
    {
        service.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
