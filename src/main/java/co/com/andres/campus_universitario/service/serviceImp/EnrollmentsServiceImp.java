package co.com.andres.campus_universitario.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.campus_universitario.config.exception.CourseException.CourseByIdNotExistException;
import co.com.andres.campus_universitario.config.exception.EnrollmentsException.EnrollmentsByIdNotExistException;
import co.com.andres.campus_universitario.config.exception.StudentsException.StudentsByIdNotExistException;
import co.com.andres.campus_universitario.mapper.EnrollmentsMapper;
import co.com.andres.campus_universitario.model.Dto.EnrollmentsRequest;
import co.com.andres.campus_universitario.model.Dto.EnrollmentsResponse;
import co.com.andres.campus_universitario.model.entity.Courses;
import co.com.andres.campus_universitario.model.entity.Enrollments;
import co.com.andres.campus_universitario.model.entity.Students;
import co.com.andres.campus_universitario.model.shared.EnrollmentsState;
import co.com.andres.campus_universitario.repository.EnrollmentsRepository;
import co.com.andres.campus_universitario.repository.StudentsRepository;
import co.com.andres.campus_universitario.service.EnrollmentsService;
import co.com.andres.campus_universitario.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentsServiceImp implements EnrollmentsService {

    private final EnrollmentsRepository enrollmentsRepository;
    private final StudentsRepository studentsRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentsMapper enrollmentsMapper;

    @Override
    public EnrollmentsResponse createEnrollments(EnrollmentsRequest enrollmentsRequest) {

        Enrollments enrollment = enrollmentsMapper.toEntity(enrollmentsRequest);
        
        Students student = studentsRepository.findById(enrollmentsRequest.students())
                .orElseThrow(() -> new StudentsByIdNotExistException(
                        "Estudiante con id" + enrollmentsRequest.students() + " NO encontrado "));

        Courses courses = courseRepository.findById(enrollmentsRequest.courses())
                .orElseThrow(() -> new CourseByIdNotExistException(
                        "Curso con id " + enrollmentsRequest.courses() + " NO encontrado"));

        enrollment.setStudents(student);
        enrollment.setCourses(courses);

        var saveEnrollment = enrollmentsRepository.save(enrollment);

        return enrollmentsMapper.toResponse(saveEnrollment);
    }

    @Override
    public List<EnrollmentsResponse> getAllEnrollments() {
        return enrollmentsRepository.findAll().stream()
            .map(enrollmentsMapper::toResponse)
            .toList();
    }

    @Override
    public EnrollmentsResponse getByIdEnrollments(Long id) {
        return enrollmentsRepository.findById(id)
        .map(enrollmentsMapper::toResponse)
        .orElseThrow(() -> new EnrollmentsByIdNotExistException("La inscripcion con id " + id + " NO existe"));
       
    }

    @Override
    public void deleteEnrollments(Long id) {
    
        var idEnrollments = enrollmentsRepository.findById(id);
        if (!idEnrollments.isPresent()) {
            throw new EnrollmentsByIdNotExistException("La inscripcion con id " + id + " NO existe");
        }
        enrollmentsRepository.deleteById(id);
    }

    @Override
    public void cancelledEnrollments(Long id) {
      
        var idEnrollments = enrollmentsRepository.findById(id);
        if (!idEnrollments.isPresent()) {
            throw new EnrollmentsByIdNotExistException("La inscripcion con id " + id + " NO existe");
        }
        var enrollment = idEnrollments.get();
        enrollment.setEnrollmentsState(EnrollmentsState.CANCELLED);
        enrollmentsRepository.save(enrollment);
    }

}
