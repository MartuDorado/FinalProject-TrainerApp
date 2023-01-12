package com.finalproject.RoutineCatalogService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
}
