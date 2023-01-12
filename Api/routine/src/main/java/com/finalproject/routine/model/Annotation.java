package com.finalproject.routine.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate DATE = LocalDate.now();
    private String commentary;
    @ManyToOne
    @JoinColumn(name = "follow_id")
    @JsonIgnore
    private FollowUp followUp;


    public Annotation(String commentary) {
    }
}
