package co.com.andres.campus_universitario.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.campus_universitario.config.exception.CourseException.CourseByIdNotExistException;
import co.com.andres.campus_universitario.mapper.CourseMapper;
import co.com.andres.campus_universitario.model.Dto.CourseRequest;
import co.com.andres.campus_universitario.model.Dto.CourseResponse;
import co.com.andres.campus_universitario.repository.CourseRepository;
import co.com.andres.campus_universitario.service.CourseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        var entity = courseMapper.toEntity(courseRequest);
        var course = courseRepository.save(entity);
        return courseMapper.toResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        var idCourse = courseRepository.findById(id);
        if (!idCourse.isPresent()) {
            throw new CourseByIdNotExistException("El curso con id " + id + " NO existe");
        }
        var course = idCourse.get();
        courseMapper.updateEntityFromRequest(courseRequest, course);
        var updatedCourse = courseRepository.save(course);
        return courseMapper.toResponse(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
      var idCourse = courseRepository.findById(id);
      if (!idCourse.isPresent()) {
        throw new CourseByIdNotExistException("El curso con id " + id + " NO existe");
      }
        courseRepository.deleteById(id);
    }

    @Override
    public CourseResponse getByIdCourse(Long id) {
        var idCourse = courseRepository.findById(id);
        if (!idCourse.isPresent()) {
            throw new CourseByIdNotExistException("El curso con id " + id + " NO existe");
        }
        var course = idCourse.get();
        return courseMapper.toResponse(course);
    }



}
