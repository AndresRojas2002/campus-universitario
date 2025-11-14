package co.com.andres.campus_universitario.model.Dto;

import co.com.andres.campus_universitario.model.entity.Professors;

public record CourseResponse(
    Long id,

    String nameCourse,

    String codeCourse,

    String description,

    Integer maxCapacity,

    Professors professors

) {

}
