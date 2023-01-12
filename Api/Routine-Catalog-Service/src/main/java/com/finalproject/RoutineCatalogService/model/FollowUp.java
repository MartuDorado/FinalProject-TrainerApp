package com.finalproject.RoutineCatalogService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUp {
    private String userName;

    private List<Routine> routines = new ArrayList<>();

    private  List<Routine> routinesDones = new ArrayList<>();



    private List<Annotation> annotations= new ArrayList<>();
}
