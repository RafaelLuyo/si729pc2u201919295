package io.newschool.platform.u201919295.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Name(String firstName, String lastName) {
    public Name(){
        this(null,null);
    }

    public Name {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }

    public String getFullName(){
        return this.firstName+ ' ' +this.lastName;
    }
}
