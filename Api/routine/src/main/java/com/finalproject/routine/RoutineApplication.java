package com.finalproject.routine;

import com.finalproject.routine.model.*;
import com.finalproject.routine.repository.BlockRepository;
import com.finalproject.routine.repository.ExerciseRepository;
import com.finalproject.routine.repository.FollowUpRepository;
import com.finalproject.routine.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RoutineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RoutineApplication.class, args);
    }

    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    BlockRepository blockRepository;
    @Autowired
    RoutineRepository routineRepository;

    @Autowired
    FollowUpRepository followUpRepository;


    public void run(String... args) throws Exception {
        Exercise exercise = new Exercise("Sentadilla", 10, "", "https://www.youtube.com/watch?v=BjixzWEw4EY&ab_channel=FisioOnline");
        Exercise exercise1 = new Exercise("Push Up", 10, "", "https://www.youtube.com/watch?v=Yd79XBIdDnI&ab_channel=PRO-BARRAS");
        exerciseRepository.save(exercise);
        exerciseRepository.save(exercise1);

        Block block = new Block("Bloque de prueba",4);
        block.getExercises().add(exercise);
        block.getExercises().add(exercise1);
        blockRepository.save(block);

        Routine routine = new Routine("Rutina de prueba", TypeOfRoutine.STRENGTH);
        routine.getBlocks().add(block);
        routineRepository.save(routine);

        FollowUp followUp = new FollowUp("sebamarchin@gmail.com");
        followUp.getRoutines().add(routine);
        followUpRepository.save(followUp);
    }
}
