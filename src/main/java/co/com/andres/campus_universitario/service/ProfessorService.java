package co.com.andres.campus_universitario.service;

import java.util.List;

import co.com.andres.campus_universitario.model.Dto.ProfessorRequest;
import co.com.andres.campus_universitario.model.Dto.ProfessorResponse;


public interface ProfessorService {

     List<ProfessorResponse> getAllProfessor();

    ProfessorResponse getById(Long id);

    ProfessorResponse createProfessor(ProfessorRequest professorRequest);

    void deleteById(Long id);

    ProfessorResponse updateProfessor(Long id, ProfessorRequest  professorRequest);

    List<ProfessorResponse> getByNameOrLastName(String text);

    List<ProfessorResponse> getByEmail(String email);

}
