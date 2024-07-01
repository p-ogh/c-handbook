package com.pogho.theCoach.sHandbook.models;

import com.pogho.theCoach.sHandbook.DAO.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TrainingSessionModel extends SessionModel {
    private List<ExerciseModel> exercises;


}
