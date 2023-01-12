package com.finalproject.routine.service.impl;

import com.finalproject.routine.model.Exercise;
import com.finalproject.routine.repository.ExerciseRepository;
import com.finalproject.routine.service.interfaces.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService implements IExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;


    public Exercise getExercise(Integer id) {
        if(exerciseRepository.findById(id).isEmpty()) throw new IllegalArgumentException("Exercise does not exist.");
        return exerciseRepository.findById(id).get();
    }


    public List<Exercise> getAllExercises() {
        if(exerciseRepository.findAll().toArray().length == 0) throw new IllegalArgumentException("No exercises saved.");
        return exerciseRepository.findAll();
    }


    public void createExercise(Exercise exercise) {
     exerciseRepository.save(exercise);
    }
}
