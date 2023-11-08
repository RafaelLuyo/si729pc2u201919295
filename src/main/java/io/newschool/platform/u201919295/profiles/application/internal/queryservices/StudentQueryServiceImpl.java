package io.newschool.platform.u201919295.profiles.application.internal.queryservices;


import io.newschool.platform.u201919295.profiles.domain.model.aggregates.StudentProfile;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetAllStudentsQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByDniQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByStreetAddressQuery;
import io.newschool.platform.u201919295.profiles.domain.services.StudentQueryService;
import io.newschool.platform.u201919295.profiles.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {
    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<StudentProfile> handle(GetStudentByDniQuery query) {
        return studentRepository.findByDni(query.dni());
    }

    @Override
    public Optional<StudentProfile> handle(GetStudentByStreetAddressQuery query) {
        return studentRepository.findByStreetAddress(query.streetAddress());
    }

    @Override
    public List<StudentProfile> handle(GetAllStudentsQuery query) {
        return studentRepository.findAll();
    }
    @Override
    public Optional<StudentProfile> handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.StudentId());
    }
}
