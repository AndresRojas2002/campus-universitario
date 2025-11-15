package co.com.andres.campus_universitario.service;

import java.util.List;

import co.com.andres.campus_universitario.model.Dto.StudentsRequest;
import co.com.andres.campus_universitario.model.Dto.StudentsResponse;

public interface StudentsService {

    List<StudentsResponse> getAllStudents();

    StudentsResponse getById(Long id);

    StudentsResponse createStudents(StudentsRequest studentsRequest);

    void deleteById(Long id);

    StudentsResponse updateStudents(Long id, StudentsRequest studentsRequest);

    List<StudentsResponse> getByNameOrLastName(String text);

    List<StudentsResponse> getByEmail(String email);

}
