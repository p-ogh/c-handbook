package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.*;
import com.pogho.theCoach.sHandbook.models.PerformanceDataModel;
import com.pogho.theCoach.sHandbook.service.PerformanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/data/")
@RestController
public class PerformanceDataController {
    @Autowired
    private PerformanceDataService service;

    @GetMapping("all")
    public ResponseEntity<List<PerformanceDataDTO>> fetchData()
    {
        return new ResponseEntity<>(service.fetchData(), HttpStatus.OK);
    }

    @GetMapping("session/{id}")
    public ResponseEntity<List<PerformanceDataDTO>> fetchSessionData(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchSessionData(id), HttpStatus.OK);
    }

    @GetMapping("athlete/{id}")
    public ResponseEntity<List<PerformanceDataDTO>> fetchAthleteData(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(service.fetchAthleteData(id), HttpStatus.OK);
    }

    @GetMapping("athlete/{id}/sessionType/{type}")
    public ResponseEntity<List<PerformanceDataDTO>> fetchAthleteData(@PathVariable("id") UUID id, @PathVariable("type") String sessionType)
    {
        return new ResponseEntity<>(service.fetchAthleteData(id, sessionType), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<PerformanceDataDTO> addNewData(@RequestBody PerformanceDataModel model)
    {
        return new ResponseEntity<>(service.addNewData(model), HttpStatus.OK);
    }

    @PutMapping("session/{id}")
    public ResponseEntity<PerformanceDataDTO> updateData(@PathVariable("id") UUID id, @RequestBody PerformanceDataModel model )
    {
        return new ResponseEntity<>(service.updateData(id, model), HttpStatus.OK);
    }



}
