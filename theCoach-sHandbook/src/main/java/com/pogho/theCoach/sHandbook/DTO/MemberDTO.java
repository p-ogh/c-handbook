package com.pogho.theCoach.sHandbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class MemberDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String role;
}
