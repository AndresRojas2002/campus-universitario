package co.com.andres.campus_universitario.model.Dto;

import java.time.LocalDate;

import co.com.andres.campus_universitario.model.entity.Courses;
import co.com.andres.campus_universitario.model.entity.Students;
import co.com.andres.campus_universitario.model.shared.EnrollmentsState;

public record EnrollmentsResponse(
        Long id,

        Students students,

        Courses Courses,

        EnrollmentsState state,

        LocalDate enrollmentDate) {

}
