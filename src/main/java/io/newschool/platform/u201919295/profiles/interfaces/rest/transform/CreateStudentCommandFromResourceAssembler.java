package io.newschool.platform.u201919295.profiles.interfaces.rest.transform;


import io.newschool.platform.u201919295.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u201919295.profiles.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(
                resource.firstName(),
                resource.lastName(),
                resource.dni(),
                resource.streetAddress(),
                resource.gender(),
                resource.birthdate(),
                resource.specialty()

        );
    }
}
