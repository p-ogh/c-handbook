package com.pogho.theCoach.sHandbook.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SleepStats  extends Record{
    private int sleepDuration;
    private int sleepQualityRating;
    private LocalDateTime bedTime;

}
