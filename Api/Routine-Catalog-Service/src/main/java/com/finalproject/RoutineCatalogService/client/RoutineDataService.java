package com.finalproject.RoutineCatalogService.client;

import com.finalproject.RoutineCatalogService.DTO.AnnotationDTO;
import com.finalproject.RoutineCatalogService.DTO.FollowUpDTO;
import com.finalproject.RoutineCatalogService.model.Block;
import com.finalproject.RoutineCatalogService.model.Exercise;
import com.finalproject.RoutineCatalogService.model.FollowUp;
import com.finalproject.RoutineCatalogService.model.Routine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("routine-data-service")
public interface RoutineDataService {

    @GetMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise getExercise(@PathVariable Integer id);

    @GetMapping("/exercises")
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> getAllExercises() ;

    @PostMapping("/exercises")
    @ResponseStatus(HttpStatus.CREATED)
    public void createExercise(@RequestBody Exercise exercise) ;

    @GetMapping("/blocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Block getBlock(@PathVariable Integer id);

    @GetMapping("/blocks")
    @ResponseStatus(HttpStatus.OK)
    public List<Block> getAllBlocks();

    @PostMapping("/blocks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlock(Block block);

    @GetMapping("/routines")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getAllRoutines() ;

    @GetMapping("/routines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Routine getRoutine(@PathVariable Integer id) ;


    @GetMapping("/routines/get-by-type/{typeOfRoutine}")
    @ResponseStatus(HttpStatus.OK)
    public List<Routine> getByType(@PathVariable String typeOfRoutine);

    @PostMapping("/routines")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoutine(@RequestBody Routine routine);

    @DeleteMapping("/routines/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoutine(@PathVariable Integer id) ;


    @PostMapping("/followUp")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFollowUp(@RequestBody FollowUpDTO followId);

    @GetMapping("/followUp/{followUpId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp getFollowUp(@PathVariable String followUpId);

    @PatchMapping("/followUp/routines/followId/routineId")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateRoutinesFollowUp(@RequestParam String followId, @RequestParam Integer routineId);
    @PatchMapping("/followUp/routines-done/followId/routineId")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateRoutinesDoneFollowUp(@RequestParam String followId, @RequestParam Integer routineId) ;
    @PatchMapping("/followUp/{followId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateAnnotationsFollowUp(@PathVariable String followId, @RequestBody AnnotationDTO annotationDTO) ;

    @PatchMapping("/followUp/edit-followUp/{followId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp editAnnotation(@PathVariable String followId, @RequestBody AnnotationDTO annotationDTO);
}
