package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.Period;

@Embeddable
public record Birthdate(LocalDate birthdate) {
    public Birthdate() {
        this(null);
    }

    public Birthdate {
        if (birthdate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null");
        }

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthdate, currentDate).getYears();

        if (age < 18) {
            throw new IllegalArgumentException("The student must be at least 18 years old");
        }
    }
}