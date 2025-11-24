package co.com.andres.campus_universitario.model.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record EnrollmentsRequest (

    @NotBlank(message = "el id del estudiante no puede ser nulo")
    @JsonAlias({"estudiante"})
    Long students,

    @NotBlank(message = "el id del curso no puede ser nulo")
    @JsonAlias({"curso"})
    Long courses,

    @Future (message = "La fecha de inscripción debe estar en el futuro"
)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate enrollmentDate ){

 public EnrollmentsRequest{

     if (enrollmentDate == null){
        enrollmentDate = LocalDate.now();
    }
}

}
