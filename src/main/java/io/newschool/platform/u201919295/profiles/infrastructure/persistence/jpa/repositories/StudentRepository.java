package io.newschool.platform.u201919295.profiles.infrastructure.persistence.jpa.repositories;


import io.newschool.platform.u201919295.profiles.domain.model.aggregates.StudentProfile;
import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.Dni;
import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.StreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByDni(Dni dni);
    Optional<StudentProfile> findByStreetAddress(StreetAddress streetAddress);
}
