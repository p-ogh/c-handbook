package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.DTO.RunSessionDTO;
import com.pogho.theCoach.sHandbook.models.RunExerciseModel;
import com.pogho.theCoach.sHandbook.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/exercise/run")
@RestController
public class RunSessionController {
    @Autowired
    private RunService runService;

    //getAllRunsforAll
    @GetMapping("all")
    public ResponseEntity<List<RunSessionDTO>> fetchRunsList()
    {
        return new ResponseEntity<>(runService.fetchRunsList(), HttpStatus.OK);
    }


    @GetMapping("{oid}")
    public ResponseEntity<RunSessionDTO> fetchRun(@PathVariable("oid") UUID oid)
    {
        return new ResponseEntity<>(runService.fetchRun(oid), HttpStatus.OK);
    }


}
