package com.finalproject.RoutineCatalogService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {

    private Integer id;
    @NotEmpty
    @NotNull
    private String title;
    @Range(min = 1,max = 10)
    private Integer laps;

    private List<Exercise> exercises = new ArrayList<>();


    @JsonIgnore
    private List<Routine> routines;
}
