package com.finalproject.RoutineCatalogService.service.impl;

import com.finalproject.RoutineCatalogService.DTO.AnnotationDTO;
import com.finalproject.RoutineCatalogService.DTO.FollowUpDTO;
import com.finalproject.RoutineCatalogService.client.RoutineDataService;
import com.finalproject.RoutineCatalogService.client.UserDataService;
import com.finalproject.RoutineCatalogService.model.Catalog;
import com.finalproject.RoutineCatalogService.model.FollowUp;
import com.finalproject.RoutineCatalogService.model.Routine;
import com.finalproject.RoutineCatalogService.model.User;
import com.finalproject.RoutineCatalogService.service.interfaces.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    UserDataService userDataService;
    @Autowired
    RoutineDataService routineDataService;


    public Catalog getCatalog(String userName) {

        try{
            Catalog catalog = new Catalog();
            User user = userDataService.getUser(userName);
            FollowUp followUp = routineDataService.getFollowUp(userName);
            catalog.setUser(user);
            catalog.setFollowUp(followUp);
            return catalog;
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


    public void createCatalog(User user) {
        try {
            Catalog catalog = new Catalog();
            userDataService.createUser(user);
            routineDataService.createFollowUp(new FollowUpDTO(user.getUserName()));

        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public List<Routine> getAllRoutines() {
        try {
          return   routineDataService.getAllRoutines();
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


    public List<Routine> getAllByType(String typeOfRoutine) {
        try {
            return routineDataService.getByType(typeOfRoutine);
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


    public Routine getRoutine(Integer routineId) {
        try{
            return routineDataService.getRoutine(routineId);
        }catch(ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public Catalog updateRoutinesFollowUp(String userName, Integer routineId) {
        try {
            Catalog catalog = new Catalog();
            User user = userDataService.getUser(userName);
            FollowUp followUp = routineDataService.getFollowUp(userName);
            catalog.setUser(user);
            catalog.setFollowUp(routineDataService.updateRoutinesFollowUp(userName,routineId));
            return catalog;
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public Catalog updateRoutinesDoneFollowUp(String userName, Integer routineId) {
        try {
            Catalog catalog = new Catalog();
            User user = userDataService.getUser(userName);
            FollowUp followUp = routineDataService.getFollowUp(userName);
            catalog.setUser(user);
            catalog.setFollowUp(routineDataService.updateRoutinesDoneFollowUp(userName,routineId));
            return catalog;
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public Catalog updateAnnotationsFollowUp(String userName, AnnotationDTO annotationDTO) {
        try {
            Catalog catalog = new Catalog();
            User user = userDataService.getUser(userName);
            FollowUp followUp = routineDataService.getFollowUp(userName);
            catalog.setUser(user);
            catalog.setFollowUp(routineDataService.updateAnnotationsFollowUp(userName,annotationDTO));
            return catalog;
        }catch (ResponseStatusException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
