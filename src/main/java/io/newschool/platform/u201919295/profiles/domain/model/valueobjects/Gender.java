package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Gender(String gender) {
    public Gender() {
        this(null);
    }

    public Gender {
        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be null or blank");
        }
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Gender must be 'Male' or 'Female'");
        }
    }
}