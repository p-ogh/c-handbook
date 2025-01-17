package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonModel {

    private String name;
    private UUID teamId;
    private Date startDate;
    private Date endDate;
    private String status;
}
