package co.com.andres.campus_universitario.model.entity;

import java.time.LocalDate;

import co.com.andres.campus_universitario.model.shared.EnrollmentsState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Students students;

    @Column(nullable = false)
    private Courses Courses;

    @Column (nullable = false)
    private EnrollmentsState state;

    @Column (nullable = false)
    private LocalDate enrollmentDate;

}
