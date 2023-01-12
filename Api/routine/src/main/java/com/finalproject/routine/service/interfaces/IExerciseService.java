package com.finalproject.routine.service.interfaces;

import com.finalproject.routine.model.Exercise;

import java.util.List;

public interface IExerciseService {
    Exercise getExercise(Integer id);
    List<Exercise>getAllExercises();
    void createExercise(Exercise exercise);
}
