package co.com.andres.campus_universitario.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameCourse;

    @Column(unique = true, nullable = false)
    private String codeCourse;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer maxCapacity;

    @Column(nullable = false)
    private Professors professors;

    public Courses(Long id) {
        this.id = id;
    }

}
