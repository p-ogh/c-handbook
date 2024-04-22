package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="exercise")
public class Exercise extends Record{
    private String name;
    private String type;
    private int duration;
    private int repetitions;
    private int sets;
    private String status;
    private boolean completed;
    private String notes;
}
