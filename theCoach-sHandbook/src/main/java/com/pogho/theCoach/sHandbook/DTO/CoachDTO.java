package com.pogho.theCoach.sHandbook.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class CoachDTO extends MemberDTO{

    public CoachDTO(UUID oid, String firstName, String lastName, String role){
        super(oid, firstName, lastName, role);
    }
}
