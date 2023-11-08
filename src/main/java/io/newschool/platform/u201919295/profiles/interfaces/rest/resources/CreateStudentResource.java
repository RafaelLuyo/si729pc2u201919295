package io.newschool.platform.u201919295.profiles.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateStudentResource(String firstName, String lastName, Long dni, String streetAddress, String gender,
                                    LocalDate birthdate, String specialty) {
}
