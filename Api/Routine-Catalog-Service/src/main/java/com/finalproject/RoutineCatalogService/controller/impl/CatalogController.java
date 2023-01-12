package com.finalproject.RoutineCatalogService.controller.impl;

import com.finalproject.RoutineCatalogService.DTO.AnnotationDTO;
import com.finalproject.RoutineCatalogService.controller.interfaces.ICatalogController;
import com.finalproject.RoutineCatalogService.model.Catalog;
import com.finalproject.RoutineCatalogService.model.Routine;
import com.finalproject.RoutineCatalogService.model.User;
import com.finalproject.RoutineCatalogService.service.interfaces.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController implements ICatalogController {
    @Autowired
    ICatalogService iCatalogService;

    @GetMapping("/catalog/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String userName) {
        return iCatalogService.getCatalog(userName);
    }

    @PostMapping("/catalog")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCatalog(@RequestBody User user) {
         iCatalogService.createCatalog(user);
    }

    @GetMapping("/catalog/routines")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getAllRoutines() {
        return iCatalogService.getAllRoutines();
    }

    @GetMapping("/catalog/routines/get-by-type/{typeOfRoutine}")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getAllByType(@PathVariable String typeOfRoutine) {
        return iCatalogService.getAllByType(typeOfRoutine);
    }

    @GetMapping("/catalog/routines/{routineId}")
    @ResponseStatus(HttpStatus.OK)
    public Routine getRoutine(@PathVariable Integer routineId) {
        return iCatalogService.getRoutine(routineId);
    }

    @PatchMapping("/catalog/user-routines/userName/routineId")
    @ResponseStatus(HttpStatus.OK)
    public Catalog updateRoutinesFollowUp(@RequestParam String userName,@RequestParam Integer routineId) {
        return iCatalogService.updateRoutinesFollowUp(userName,routineId);
    }

    @PatchMapping("/catalog/user-routines-done/userName/routineId")
    @ResponseStatus(HttpStatus.OK)
    public Catalog updateRoutinesDoneFollowUp(@RequestParam String userName, @RequestParam Integer routineId) {
        return iCatalogService.updateRoutinesDoneFollowUp(userName,routineId);
    }

    @PatchMapping("/catalog/user-followUp-update/{userName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Catalog updateAnnotationsFollowUp(@PathVariable String userName, @RequestBody AnnotationDTO annotationDTO) {
        return iCatalogService.updateAnnotationsFollowUp(userName, annotationDTO);
    }
}
