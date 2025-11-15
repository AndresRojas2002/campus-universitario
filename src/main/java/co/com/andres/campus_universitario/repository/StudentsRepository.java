package co.com.andres.campus_universitario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.campus_universitario.model.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    List<Students> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String text, String text2);

    List<Students> findByEmailContainingIgnoreCase(String email);
}
