package io.newschool.platform.u201919295.profiles.interfaces.rest.resources;

import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.*;



public record StudentResource(
        Long id,
        String fullName,
        Dni dni,
        StreetAddress streetAddress,
        Gender gender,
        Birthdate birthdate,
        Specialty specialty
) {
}