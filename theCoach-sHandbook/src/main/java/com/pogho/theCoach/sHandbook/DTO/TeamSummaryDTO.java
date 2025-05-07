package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TeamSummaryDTO {
    private UUID id;
    private String name;
    private int players;
    private int events;
    private int seasons;
    private int games;

}
