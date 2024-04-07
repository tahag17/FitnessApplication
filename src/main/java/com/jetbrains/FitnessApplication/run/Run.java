package com.jetbrains.FitnessApplication.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;



public record Run(
        @Id     //here telling the run repository that this is the id of our 'table'
        Integer id,
        @NotEmpty
        String name,
        LocalDateTime start,
        LocalDateTime finish,
        Location location,
        @Positive //making sure that miles are positive ;))
        Integer miles,
        //a way to track whether this a new row or an existing row
        @Version  //a way to track whether this a new row or an existing row
        Integer version
) {
//    public Run {
//        if (!start().isAfter(finish)) {
//            throw new IllegalArgumentException();
//        }
//    }
}

;