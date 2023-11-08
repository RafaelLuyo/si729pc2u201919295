package io.newschool.platform.u201919295.profiles.interfaces.acl;


import io.newschool.platform.u201919295.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByDniQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByStreetAddressQuery;
import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.Dni;
import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.StreetAddress;
import io.newschool.platform.u201919295.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u201919295.profiles.domain.services.StudentQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentsContextFacade {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentsContextFacade(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    public Long createStudent( String firstName,String lastName,Long dni,String streetAddress,String gender,LocalDate birthdate,String specialty) {
        var createStudentCommand = new CreateStudentCommand(firstName, lastName, dni, streetAddress, gender, birthdate, specialty);
        return studentCommandService.handle(createStudentCommand);
    }

    public Long getStudentByDNI(Long dni) {
        var getStudentByDNIQuery = new GetStudentByDniQuery(new Dni(dni));
        var student = studentQueryService.handle(getStudentByDNIQuery);
        if (student.isEmpty()) {
            return 0L;
        }
        return student.get().getId();
    }
    public Long getStudentByStreetAddress(String streetaddress) {
        var getStudentByStreetAddressQuery = new GetStudentByStreetAddressQuery(new StreetAddress(streetaddress));
        var student = studentQueryService.handle(getStudentByStreetAddressQuery);
        if (student.isEmpty()) {
            return 0L;
        }
        return student.get().getId();
    }
}
