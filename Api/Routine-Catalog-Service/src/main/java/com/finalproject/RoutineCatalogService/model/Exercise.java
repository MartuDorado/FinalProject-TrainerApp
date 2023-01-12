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
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    private Integer id;

    @NotNull
    @NotEmpty
    private String name;
    @Range(min = 1, max = 50)
    private Integer reps;
    private String description;
    private String video;

    @JsonIgnore
    private List<Block> blocks = new ArrayList<>();
}
