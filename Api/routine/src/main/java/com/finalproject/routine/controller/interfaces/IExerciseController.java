package com.finalproject.routine.controller.interfaces;

import com.finalproject.routine.model.Exercise;

import java.util.List;

public interface IExerciseController {
    Exercise getExercise(Integer id);
    List<Exercise> getAllExercises();
    void createExercise(Exercise exercise);
}
