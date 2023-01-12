package com.finalproject.routine.controller.impl;

import com.finalproject.routine.controller.interfaces.IRoutineController;
import com.finalproject.routine.model.Routine;
import com.finalproject.routine.model.TypeOfRoutine;
import com.finalproject.routine.service.interfaces.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RoutineController implements IRoutineController {
    @Autowired
    IRoutineService iRoutineService;

    @GetMapping("/routines")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getAllRoutines() {
        try{
          return iRoutineService.getAllRoutines();
        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/routines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Routine getRoutine(@PathVariable Integer id) {
        try{
           return iRoutineService.getRoutine(id);
        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/routines/get-by-type/{typeOfRoutine}")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getByType(@PathVariable String typeOfRoutine) {
       try {
           return iRoutineService.getByType(typeOfRoutine);
       }catch (IllegalArgumentException i){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping("/routines")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoutine(@RequestBody Routine routine) {
     try {
          iRoutineService.createRoutine(routine);
     }catch (IllegalArgumentException i){
         throw new ResponseStatusException(HttpStatus.CONFLICT);
     }
    }

    @DeleteMapping("/routines/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoutine(@PathVariable Integer id) {
       try {
           iRoutineService.deleteRoutine(id);
       }catch (IllegalArgumentException i){
           throw new ResponseStatusException(HttpStatus.CONFLICT);
       }
    }

   /* @Override
    public Routine updateRoutine(Integer id) {
        return null;
    }*/
}
