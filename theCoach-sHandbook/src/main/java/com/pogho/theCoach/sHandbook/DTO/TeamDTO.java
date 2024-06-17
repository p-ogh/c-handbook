package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TeamDTO {
    private UUID id;
    private String name;
    private String sport;
    private String status;
    private List<UUID> seasons;

}
