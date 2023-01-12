package com.finalproject.RoutineCatalogService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotation {
    private Integer id;
    private final LocalDate DATE = LocalDate.now();
    private String commentary;
    @JsonIgnore
    private FollowUp followUp;

}
