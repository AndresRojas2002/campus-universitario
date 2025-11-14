package co.com.andres.campus_universitario.model.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.andres.campus_universitario.model.entity.Courses;
import co.com.andres.campus_universitario.model.entity.Students;
import jakarta.validation.constraints.NotBlank;

public record EnrollmentsRequest (

    @NotBlank(message = "el id del estudiante no puede ser nulo")
    @JsonAlias({"estudiante"})
    Students students,

    @NotBlank(message = "el id del curso no puede ser nulo")
    @JsonAlias({"curso"})
    Courses courses,

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate enrollmentDate ){

 public EnrollmentsRequest{

     if (enrollmentDate == null){
        enrollmentDate = LocalDate.now();
    }
}

}
