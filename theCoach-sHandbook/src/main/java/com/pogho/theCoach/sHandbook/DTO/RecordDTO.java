package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private UUID id;
    private UUID athleteId;
    private LocalDateTime created;
    private String notes;

}
