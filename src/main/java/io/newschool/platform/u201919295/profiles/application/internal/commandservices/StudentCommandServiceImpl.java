package io.newschool.platform.u201919295.profiles.application.internal.commandservices;


import io.newschool.platform.u201919295.profiles.domain.model.aggregates.StudentProfile;
import io.newschool.platform.u201919295.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.*;
import io.newschool.platform.u201919295.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u201919295.profiles.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateStudentCommand command) {
        var streetAddress = new StreetAddress(command.streetAddress());
        var gender = new Gender(command.gender());
        var birthdate = new Birthdate(command.birthdate());
        var specialty = new Specialty(command.specialty());
        var dni = new Dni(command.dni());
        studentRepository.findByDni(dni).map(profile -> {
            throw new IllegalArgumentException("Profile with DNI "+ command.dni() + "already exists");
        });
        studentRepository.findByStreetAddress(streetAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with StreetAddress "+ command.dni() + "already exists");
        });
        var student = new StudentProfile(command.firstName(), command.lastName(), dni, streetAddress, gender, birthdate, specialty);
        studentRepository.save(student);
        return student.getId();
    }
}
