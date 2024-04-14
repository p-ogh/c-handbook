package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Record {
    @Id
    private UUID id;
    private UUID athleteId;
    @CreatedDate
    private LocalDateTime created;
}
