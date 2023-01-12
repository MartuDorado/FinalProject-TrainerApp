package com.finalproject.routine.service.impl;

import com.finalproject.routine.model.Routine;
import com.finalproject.routine.model.TypeOfRoutine;
import com.finalproject.routine.repository.RoutineRepository;
import com.finalproject.routine.service.interfaces.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineService implements IRoutineService {
    @Autowired
    RoutineRepository routineRepository;


    public List<Routine> getAllRoutines() {
        if(routineRepository.findAll().toArray().length==0)throw new IllegalArgumentException("No routines saved.");
        return routineRepository.findAll();
    }


    public Routine getRoutine(Integer id) {
        if(routineRepository.findById(id).isEmpty())throw new IllegalArgumentException("Routine does not exist.");
        return routineRepository.findById(id).get();
    }


    public List<Routine> getByType(String typeOfRoutine) {
        if(routineRepository.findAllRoutinesByTypeOfRoutine(TypeOfRoutine.valueOf(typeOfRoutine)).toArray().length==0)
            throw new IllegalArgumentException("There are no such routines.");

        return routineRepository.findAllRoutinesByTypeOfRoutine(TypeOfRoutine.valueOf(typeOfRoutine));
    }


    public void createRoutine(Routine routine) {
       routineRepository.save(routine);
    }


    public void deleteRoutine(Integer id) {
        if(routineRepository.findById(id).isEmpty())throw new IllegalArgumentException("Routine not found.");
        routineRepository.deleteById(id);
    }

     //BACKLOG
    public Routine updateRoutine(Integer id) {
        return null;
    }
}
