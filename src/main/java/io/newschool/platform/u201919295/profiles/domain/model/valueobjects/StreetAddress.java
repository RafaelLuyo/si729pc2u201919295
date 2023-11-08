package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(String streetaddress) {
    public StreetAddress() {
        this(null);
    }

    public StreetAddress {
        if (streetaddress == null || streetaddress.isBlank()) {
            throw new IllegalArgumentException("StreetAddress cannot be null or blank");
        }

    }
}