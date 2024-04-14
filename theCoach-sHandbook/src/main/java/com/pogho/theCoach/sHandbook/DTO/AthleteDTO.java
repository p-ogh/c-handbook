package com.pogho.theCoach.sHandbook.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AthleteDTO extends MemberDTO{

    public AthleteDTO(UUID oid, String firstName, String lastName, String role){
        super(oid, firstName, lastName, role);
    }
}
