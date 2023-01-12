package com.finalproject.routine.service.interfaces;

import com.finalproject.routine.DTO.AnnotationDTO;
import com.finalproject.routine.DTO.FollowUpDTO;
import com.finalproject.routine.model.FollowUp;

public interface IFollowUpService {
    void createFollowUp(FollowUpDTO followId);
    FollowUp getFollowUp(String followUpId);
    FollowUp updateRoutinesFollowUp(String followId, Integer routineId);
    FollowUp updateRoutinesDoneFollowUp(String followId,Integer routineId);
    FollowUp updateAnnotationsFollowUp(String followId, AnnotationDTO annotationDTO);
    FollowUp editAnnotation(String followId,AnnotationDTO annotationDTO);
}
