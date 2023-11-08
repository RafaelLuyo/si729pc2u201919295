package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Specialty(String specialty) {

    public Specialty(){
        this(null);
    }
    public Specialty {
        if (specialty == null || specialty.isBlank()) {
            throw new IllegalArgumentException("Specialty cannot be null or blank");
        }
    }
}
