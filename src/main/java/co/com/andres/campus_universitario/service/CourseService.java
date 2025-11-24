package co.com.andres.campus_universitario.service;

import java.util.List;

import co.com.andres.campus_universitario.model.Dto.CourseRequest;
import co.com.andres.campus_universitario.model.Dto.CourseResponse;

public interface CourseService {

    CourseResponse createCourse(CourseRequest courseRequest);

    List<CourseResponse> getAllCourses();

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    void deleteCourse(Long id);

    CourseResponse getByIdCourse(Long id);

}
