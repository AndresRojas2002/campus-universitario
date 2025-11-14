package co.com.andres.campus_universitario.model.Dto;


import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseRequest(

@NotBlank(message = "el curso no puede ser nulo")
@JsonAlias({"nombre_curso", "curso"})
String nameCourse,

@NotBlank(message = "el codigo del curso no puede ser nulo")
@Size(min = 6, max = 15, message = "el codigo debe ser entre 6 a 15 caracteres" )
@JsonAlias({"codigo-curso", "codigo"})
String codeCourse,


@JsonAlias({"descripcion"})
String description,

@JsonAlias({"maxima_capacidad", "capacidad"})
@Size(min = 10, max = 50, message = "la capaxidad del curso debe estar entre 10 a 50 estudiantes ")
Integer maxCapacity,

@JsonAlias({"profesor", "maestro"})
@NotBlank(message = "el curso debe tener un profesor asignado")
ProfessorRequest Professors

 ) {
public CourseRequest{
  if (description == null) {
    description = "no hay descripcion disponible";
    
}
  if (maxCapacity == null) {
    maxCapacity = 50;
    
}


    }
    

}
