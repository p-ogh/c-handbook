package com.pogho.theCoach.sHandbook.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal extends Record{
    private String name;
    private String description;
    private int caloriesIntake;
    private String mealType; //breakfast,lunch,dinner,snack
    private String alteration;
    private LocalDateTime scheduledTime;
    private LocalDateTime consumptionTime;
    private boolean eaten;

}
