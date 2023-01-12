package com.finalproject.routine.service.impl;

import com.finalproject.routine.DTO.AnnotationDTO;
import com.finalproject.routine.DTO.FollowUpDTO;
import com.finalproject.routine.model.Annotation;
import com.finalproject.routine.model.FollowUp;
import com.finalproject.routine.model.Routine;
import com.finalproject.routine.repository.FollowUpRepository;
import com.finalproject.routine.repository.RoutineRepository;
import com.finalproject.routine.service.interfaces.IFollowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowUpService implements IFollowUpService {
    @Autowired
    FollowUpRepository followUpRepository;
    @Autowired
    RoutineRepository routineRepository;



    public void createFollowUp(FollowUpDTO followUpDTO) {
        if(followUpRepository.findById(followUpDTO.getFollowId()).isPresent())throw new IllegalArgumentException("FollowUp already exist.");
        FollowUp followUp = new FollowUp(followUpDTO.getFollowId());
        followUpRepository.save(followUp);
    }

    @Override
    public FollowUp getFollowUp(String followUpId) {
        if (followUpRepository.findById(followUpId).isEmpty())throw new IllegalArgumentException("FollowUp does not exist.");
         return followUpRepository.findById(followUpId).get();
    }

    public FollowUp updateRoutinesFollowUp(String followId, Integer routineId) {
        if(followUpRepository.findById(followId).isEmpty())throw new IllegalArgumentException("Action denied");
        FollowUp followUp = followUpRepository.findById(followId).get();
        if(routineRepository.findById(routineId).isEmpty())throw new IllegalArgumentException("Routine does not extist.");
        Routine routine = routineRepository.findById(routineId).get();
        if(followUp.getRoutines().contains(routine)) followUp.getRoutines().remove(routine);
        followUp.getRoutines().add(routine);
        followUpRepository.save(followUp);
        return followUp;
    }


    public FollowUp updateRoutinesDoneFollowUp(String followId, Integer routineId) {
        if(followUpRepository.findById(followId).isEmpty())throw new IllegalArgumentException("Action denied");
        FollowUp followUp = followUpRepository.findById(followId).get();
        if(routineRepository.findById(routineId).isEmpty())throw new IllegalArgumentException("Routine does not extist.");
        Routine routine = routineRepository.findById(routineId).get();
        if(followUp.getRoutinesDones().contains(routine)) followUp.getRoutinesDones().remove(routine);
        followUp.getRoutinesDones().add(routine);
        followUpRepository.save(followUp);
        return followUp;
    }


    public FollowUp updateAnnotationsFollowUp(String followId, AnnotationDTO annotationDTO) {
        if(followUpRepository.findById(followId).isEmpty())throw new IllegalArgumentException("Action denied");
        FollowUp followUp = followUpRepository.findById(followId).get();
        followUp.getAnnotations().add(new Annotation(annotationDTO.getCommentary()));
        followUpRepository.save(followUp);
        return followUp;
    }


    public FollowUp editAnnotation(String followId, AnnotationDTO annotationDTO) {
        if(followUpRepository.findById(followId).isEmpty())throw new IllegalArgumentException("Action denied");
        FollowUp followUp = followUpRepository.findById(followId).get();
        followUp.getAnnotations().forEach(annotation -> {
            if(annotation.getDATE().toString().equals(annotationDTO.getDate()))
                annotation.setCommentary(annotationDTO.getCommentary());
        });
        followUpRepository.save(followUp);
        return followUp;
    }
}
