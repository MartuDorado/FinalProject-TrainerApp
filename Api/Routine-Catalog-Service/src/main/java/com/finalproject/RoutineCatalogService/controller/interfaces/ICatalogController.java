package com.finalproject.RoutineCatalogService.controller.interfaces;

import com.finalproject.RoutineCatalogService.DTO.AnnotationDTO;
import com.finalproject.RoutineCatalogService.model.Catalog;
import com.finalproject.RoutineCatalogService.model.Routine;
import com.finalproject.RoutineCatalogService.model.User;

import java.util.List;

public interface ICatalogController {
    Catalog getCatalog(String userName);
    void createCatalog(User user);
    List<Routine> getAllRoutines();
    List<Routine> getAllByType(String typeOfRoutine);
    Routine getRoutine(Integer routineId);
    Catalog updateRoutinesFollowUp(String userName,Integer routineId );
    Catalog updateRoutinesDoneFollowUp(String userName, Integer routineId);
    Catalog updateAnnotationsFollowUp(String userName, AnnotationDTO annotationDTO);
}
