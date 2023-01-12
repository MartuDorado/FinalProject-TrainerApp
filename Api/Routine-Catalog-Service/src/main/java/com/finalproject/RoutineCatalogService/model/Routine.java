package com.finalproject.RoutineCatalogService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Routine {

    private Integer id;
    private final LocalDate CREATION_DATE = LocalDate.now();
    @NotNull
    @NotEmpty
    private String title;

    private List<Block> blocks = new ArrayList<>();



    @JsonIgnore
    private List<FollowUp> followUpsActives;


    @JsonIgnore
    private List<FollowUp>followUpsDones;
}
