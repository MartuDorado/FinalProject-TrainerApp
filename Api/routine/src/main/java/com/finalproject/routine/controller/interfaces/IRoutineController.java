package com.finalproject.routine.controller.interfaces;

import com.finalproject.routine.model.Routine;
import com.finalproject.routine.model.TypeOfRoutine;

import java.util.List;

public interface IRoutineController {

    List<Routine> getAllRoutines();
    Routine getRoutine(Integer id);
    List<Routine>getByType(String typeOfRoutine);
    void createRoutine(Routine routine);
    void deleteRoutine(Integer id);
    //BACKLOG
   // Routine updateRoutine(Integer id);
}
