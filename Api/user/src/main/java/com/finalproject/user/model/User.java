package com.finalproject.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Email
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String password;

    @NotEmpty
    @NotNull
    private String name;
    @DateTimeFormat
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    private long age;


    public User(String userName, String password, String name,LocalDate dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        setAge();
    }

    public void setAge() {
        this.age =  ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
    }
}

