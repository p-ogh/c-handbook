package com.pogho.theCoach.sHandbook.controller;

import com.pogho.theCoach.sHandbook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author pogho
 */
@RequestMapping("members")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;




}
