package com.pogho.theCoach.sHandbook.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private  UUID id;
    private String name;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String province;
    private String postalCode;
    private String country;
}
