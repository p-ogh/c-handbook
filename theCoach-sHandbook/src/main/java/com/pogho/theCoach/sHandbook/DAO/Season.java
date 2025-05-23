package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Season {
    @Id
    private UUID id;
    private String name;

    private UUID teamId;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    private String status;


    public void updateSeason (String name, Date startDate, Date endDate, String status){
        this.name = name;
        this.startDate= startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
