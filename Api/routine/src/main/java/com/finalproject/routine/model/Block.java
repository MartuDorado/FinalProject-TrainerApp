package com.finalproject.routine.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @NotNull
    private String title;
    @Range(min = 1,max = 10)
    private Integer laps;
    @ManyToMany
    @JoinTable(
            name = "block_exercise",
            joinColumns = @JoinColumn(name = "block_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToMany(mappedBy = "blocks")
    @JsonIgnore
    private List<Routine> routines;

    public Block(String title, Integer laps) {
        this.title = title;
        this.laps = laps;
    }
}
