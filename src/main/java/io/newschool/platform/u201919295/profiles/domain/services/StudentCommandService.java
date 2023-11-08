package io.newschool.platform.u201919295.profiles.domain.services;

import io.newschool.platform.u201919295.profiles.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
