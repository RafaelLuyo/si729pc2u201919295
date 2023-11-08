package io.newschool.platform.u201919295.profiles.interfaces.rest;


import io.newschool.platform.u201919295.profiles.domain.model.queries.GetAllStudentsQuery;
import io.newschool.platform.u201919295.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u201919295.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u201919295.profiles.domain.services.StudentQueryService;
import io.newschool.platform.u201919295.profiles.interfaces.rest.resources.CreateStudentResource;
import io.newschool.platform.u201919295.profiles.interfaces.rest.resources.StudentResource;
import io.newschool.platform.u201919295.profiles.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import io.newschool.platform.u201919295.profiles.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProfilesController
 * <p>
 *     Profile Management Endpoints
 *     <ul>
 *         <li>Create a new Student</li>
 *         <li>Get Student by Identifier</li>
 *         <li>Get all Students</li>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Student", description = "Student Management Endpoints")
public class StudentsController {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentsController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    /**
     * Create a new Student
     * @param resource Create Student Resource including the profile data
     * @return Student Resource if created, otherwise 400
     * @see StudentResource
     * @see CreateStudentResource
     */
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandService.handle(createStudentCommand);
        if (studentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProfileByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getProfileByIdQuery);

        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    /**
     * Get all Students
     * @return List of Student Resources currently available
     * @see StudentResource
     */
    @GetMapping
    public ResponseEntity<List<StudentResource>>  getAllStudents() {
        var getAllStudentsQuery = new GetAllStudentsQuery();
        var students = studentQueryService.handle(getAllStudentsQuery);
        var studentsresources = students.stream().map(StudentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(studentsresources);
    }
}
