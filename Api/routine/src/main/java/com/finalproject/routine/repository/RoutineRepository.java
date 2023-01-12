package com.finalproject.routine.repository;

import com.finalproject.routine.model.Routine;
import com.finalproject.routine.model.TypeOfRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    List<Routine>findAllRoutinesByTypeOfRoutine(TypeOfRoutine typeOfRoutine);
}
