package com.finalproject.routine.controller.impl;

import com.finalproject.routine.DTO.AnnotationDTO;
import com.finalproject.routine.DTO.FollowUpDTO;
import com.finalproject.routine.controller.interfaces.IFollowUpController;
import com.finalproject.routine.model.FollowUp;
import com.finalproject.routine.service.interfaces.IFollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowUpController implements IFollowUpController {

    @Autowired
    IFollowUpService iFollowUpService;

    @PostMapping("/followUp")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFollowUp(@RequestBody FollowUpDTO followId) {
        iFollowUpService.createFollowUp(followId);
    }

    @GetMapping("/followUp/{followUpId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp getFollowUp(@PathVariable String followUpId) {
        return iFollowUpService.getFollowUp(followUpId);
    }

    @PatchMapping("/followUp/routines/followId/routineId")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateRoutinesFollowUp(@RequestParam String followId, @RequestParam Integer routineId) {
        return iFollowUpService.updateRoutinesFollowUp(followId,routineId);
    }

    @PatchMapping("/followUp/routines-done/followId/routineId")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateRoutinesDoneFollowUp(@RequestParam String followId, @RequestParam Integer routineId) {
        return iFollowUpService.updateRoutinesDoneFollowUp(followId,routineId);
    }

    @PatchMapping("/followUp/{followId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp updateAnnotationsFollowUp(@PathVariable String followId, @RequestBody AnnotationDTO annotationDTO) {
        return iFollowUpService.updateAnnotationsFollowUp(followId,annotationDTO);
    }

    @PatchMapping("/followUp/edit-followUp/{followId}")
    @ResponseStatus(HttpStatus.OK)
    public FollowUp editAnnotation(@PathVariable String followId, @RequestBody AnnotationDTO annotationDTO) {
        return iFollowUpService.editAnnotation(followId,annotationDTO);
    }
}
