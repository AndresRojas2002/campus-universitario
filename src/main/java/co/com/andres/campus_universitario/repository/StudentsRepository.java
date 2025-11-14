package co.com.andres.campus_universitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.campus_universitario.model.entity.Students;

public interface StudentsRepository extends JpaRepository<Long, Students> {
    
}
