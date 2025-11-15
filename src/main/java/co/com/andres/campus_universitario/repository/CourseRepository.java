package co.com.andres.campus_universitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.andres.campus_universitario.model.entity.Courses;

public interface CourseRepository extends JpaRepository <Courses, Long>{
    
}
