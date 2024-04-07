package com.jetbrains.FitnessApplication.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String name,
        LocalDateTime start,
        LocalDateTime finish,
        Location location,
        @Positive
        Integer miles

) {
//    public Run {
//        if (!start().isAfter(finish)) {
//            throw new IllegalArgumentException();
//        }
//    }
}

;