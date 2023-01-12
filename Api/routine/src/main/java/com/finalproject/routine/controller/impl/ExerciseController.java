package com.finalproject.routine.controller.impl;

import com.finalproject.routine.controller.interfaces.IExerciseController;
import com.finalproject.routine.model.Exercise;
import com.finalproject.routine.service.interfaces.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ExerciseController implements IExerciseController {
    @Autowired
    IExerciseService iExerciseService;

    @GetMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise getExercise(@PathVariable Integer id) {
        try {
            return iExerciseService.getExercise(id);
        } catch (IllegalArgumentException i) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exercises")
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> getAllExercises() {
        try {
            return iExerciseService.getAllExercises();
        } catch (IllegalArgumentException i) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

     @PostMapping("/exercises")
     @ResponseStatus(HttpStatus.CREATED)
    public void createExercise(@RequestBody Exercise exercise) {
  try {
      iExerciseService.createExercise(exercise);
  }catch (IllegalArgumentException i){
      throw new ResponseStatusException(HttpStatus.CONFLICT);
  }
    }
}
