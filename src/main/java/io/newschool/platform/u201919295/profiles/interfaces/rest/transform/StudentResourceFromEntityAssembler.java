package io.newschool.platform.u201919295.profiles.interfaces.rest.transform;


import io.newschool.platform.u201919295.profiles.domain.model.aggregates.StudentProfile;
import io.newschool.platform.u201919295.profiles.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(StudentProfile entity) {
        return new StudentResource(entity.getId(), entity.getFullName(), entity.getDni(), entity.getStreetAddress(),entity.getGender(),entity.getBirthdate(),entity.getSpecialty());
    }
}
