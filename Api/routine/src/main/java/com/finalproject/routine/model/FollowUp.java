package com.finalproject.routine.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class FollowUp {
    @Id
    private String userName;
    @ManyToMany
    @JoinTable(
            name = "followUp_routines",
            joinColumns = @JoinColumn(name = "followUp_id"),
            inverseJoinColumns = @JoinColumn(name = "routine_id"))
    private  List<Routine> routines = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "followUp_routines_dones",
            joinColumns = @JoinColumn(name = "followUp_id"),
            inverseJoinColumns = @JoinColumn(name = "routine_id"))
    private  List<Routine> routinesDones = new ArrayList<>();


    @OneToMany(mappedBy = "followUp")
    private List<Annotation> annotations= new ArrayList<>();

    public FollowUp(String userName) {
        this.userName = userName;
    }
}
