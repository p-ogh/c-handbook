package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDataDTO extends RecordDTO{
    private UUID sessionId;
    private String sessionType;
    private UUID athleteId;
    private int rating;


}
