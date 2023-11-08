package io.newschool.platform.u201919295.profiles.domain.model.commands;

import java.time.LocalDate;

public record CreateStudentCommand(
        String firstName,
        String lastName,
        Long dni,
        String streetAddress,

        String gender,
        LocalDate birthdate,
        String specialty)
{
}
