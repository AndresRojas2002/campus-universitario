package co.com.andres.campus_universitario.model.entity;

import java.time.LocalDate;

import co.com.andres.campus_universitario.model.shared.EnrollmentsState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    private Students students;

    @ManyToOne
    private Courses courses;

    @Column (nullable = false)
    private EnrollmentsState enrollmentsState;

    @Column (nullable = false)
    private LocalDate enrollmentDate;

}
