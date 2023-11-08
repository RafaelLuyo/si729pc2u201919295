package io.newschool.platform.u201919295.profiles.domain.services;

import io.newschool.platform.u201919295.profiles.domain.model.aggregates.StudentProfile;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetAllStudentsQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByDniQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByStreetAddressQuery;

import java.util.List;
import java.util.Optional;

public interface StudentQueryService {
    Optional<StudentProfile> handle(GetStudentByDniQuery query);
    Optional<StudentProfile> handle(GetStudentByStreetAddressQuery query);
    List<StudentProfile> handle(GetAllStudentsQuery query);
    Optional<StudentProfile> handle(GetStudentByIdQuery query);
}
