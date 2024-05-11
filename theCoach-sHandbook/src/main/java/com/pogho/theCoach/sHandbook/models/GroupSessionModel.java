package com.pogho.theCoach.sHandbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupSessionModel extends SessionModel {
    private List<UUID> athleteIds;
    private HashMap<UUID, List<ExerciseModel>> exercisesMap;
    private List<ExerciseModel> exerciseType;

}
