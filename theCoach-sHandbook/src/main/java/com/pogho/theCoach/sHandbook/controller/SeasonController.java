package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.SeasonDTO;
import com.pogho.theCoach.sHandbook.models.SeasonModel;
import com.pogho.theCoach.sHandbook.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/season")
@RestController
public class SeasonController {

    @Autowired
    private SeasonService service;

    //getUsers
    @GetMapping("all")
    public ResponseEntity<List<SeasonDTO>> fetchSeasonsList()
    {
        return new ResponseEntity<>(service.fetchSeasonsList(), HttpStatus.OK);

    }

    //getUser
    @GetMapping("season/{id}")
    public ResponseEntity<SeasonDTO> fetchSeason(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchSeason(id), HttpStatus.OK);

    }

    //addUser
    @PostMapping("season")
    public ResponseEntity<SeasonDTO> saveSeason(@RequestBody SeasonModel model) {

        return new ResponseEntity<>(service.saveSeason(model), HttpStatus.CREATED);

    }


    //updateUser
    @PutMapping("season/{id}")
    public ResponseEntity<SeasonDTO> updateSeason(@PathVariable("id")UUID id, @RequestBody SeasonModel model)
    {
        return new ResponseEntity<>(service.updateSeason(id, model), HttpStatus.OK);
    }


    //updateUser
    @DeleteMapping("season/{id}")
    public ResponseEntity<HttpStatusCode> deleteSeason(@PathVariable("id")UUID id)
    {
        service.deleteSeason(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
