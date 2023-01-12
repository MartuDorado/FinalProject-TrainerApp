package com.finalproject.routine.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate CREATION_DATE = LocalDate.now();
    @NotNull
    @NotEmpty
    private String title;
    @Enumerated(EnumType.STRING)
    private TypeOfRoutine typeOfRoutine;
    @ManyToMany
    @JoinTable(
            name = "routine_block",
            joinColumns = @JoinColumn(name = "routine_id"),
            inverseJoinColumns = @JoinColumn(name = "block_id"))
    private List<Block>blocks = new ArrayList<>();


    @ManyToMany(mappedBy = "routines")
    @JsonIgnore
    private List<FollowUp> followUpsActives;
    @ManyToMany(mappedBy = "routinesDones")
    @JsonIgnore
    private List<FollowUp>followUpsDones;



    public Routine(String title, TypeOfRoutine typeOfRoutine) {
        this.title = title;
        this.typeOfRoutine = typeOfRoutine;
    }
}
