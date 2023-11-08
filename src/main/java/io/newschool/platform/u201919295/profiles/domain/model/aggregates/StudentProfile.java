package io.newschool.platform.u201919295.profiles.domain.model.aggregates;


import io.newschool.platform.u201919295.profiles.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class StudentProfile extends AbstractAggregateRoot<StudentProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Embedded
    private Name name;


    @Setter

    @Embedded
    private Dni dni;


    @Setter
    @Embedded
    private StreetAddress streetAddress;
    @Setter
    @Embedded
    private Gender gender;

    @Setter
    @Embedded
    private Birthdate birthdate;
    @Setter
    @Embedded
    private Specialty specialty;

    public StudentProfile(String firstName, String lastName, Dni dni, StreetAddress streetAddress, Gender gender, Birthdate birthdate, Specialty specialty ){
        this.name=new Name(firstName,lastName);
        this.dni=dni;
        this.streetAddress= streetAddress;
        this.gender=gender;
        this.birthdate=birthdate;
        this.specialty=specialty;
    }
    public StudentProfile(){}
    public String getFullName() {
        return name.getFullName();
    }


}