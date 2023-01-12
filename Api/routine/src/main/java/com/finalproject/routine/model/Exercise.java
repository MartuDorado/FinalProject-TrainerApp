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
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;
    @Range(min = 1, max = 50)
    private Integer reps;
    private String description;
    private String video;
    @ManyToMany(mappedBy = "exercises")
    @JsonIgnore
    private List<Block>blocks = new ArrayList<>();

    public Exercise(String name, Integer reps, String description, String video) {
        this.name = name;
        this.reps = reps;
        this.description = description;
        this.video = video;
    }


}
