package com.finalproject.routine.service.interfaces;

import com.finalproject.routine.model.Routine;
import com.finalproject.routine.model.TypeOfRoutine;

import java.util.List;
import java.util.Optional;

public interface IRoutineService {

    List<Routine>getAllRoutines();
    Routine getRoutine(Integer id);
    List<Routine>getByType(String typeOfRoutine);
    void createRoutine(Routine routine);
    void deleteRoutine(Integer id);
    Routine updateRoutine(Integer id);

}
