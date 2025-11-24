package co.com.andres.campus_universitario.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.campus_universitario.config.exception.ProfessorException.ProfessorByIdNotExistException;
import co.com.andres.campus_universitario.mapper.ProfessorMapper;
import co.com.andres.campus_universitario.model.Dto.ProfessorRequest;
import co.com.andres.campus_universitario.model.Dto.ProfessorResponse;
import co.com.andres.campus_universitario.repository.ProfessorRepository;
import co.com.andres.campus_universitario.service.ProfessorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImp implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Override
    public List<ProfessorResponse> getAllProfessor() {
        return professorRepository.findAll().stream()
                .map(professorMapper::toResponse)
                .toList();

    }

    @Override
    public ProfessorResponse getById(Long id) {
        return professorRepository.findById(id)
                .map(professorMapper::toResponse)
                .orElseThrow(() -> new ProfessorByIdNotExistException("El profesor con id " + id + " no existe"));
    }

    @Override
    public ProfessorResponse createProfessor(ProfessorRequest professorRequest) {
        // TODO encriptar contraseña
        var entity = professorMapper.toEntity(professorRequest);
        var professor = professorRepository.save(entity);
        return professorMapper.toResponse(professor);
    }

    @Override
    public void deleteById(Long id) {
        var idProfessor = professorRepository.findById(id);
        if (!idProfessor.isPresent()) {
            throw new ProfessorByIdNotExistException("El profesor con id " + id + " no existe");
        }

        var professor = idProfessor.get();
        professorRepository.delete(professor);
    }

    @Override
    public ProfessorResponse updateProfessor(Long id, ProfessorRequest professorRequest) {
        // TODO Auto-generated method stub
        var idProfessor = professorRepository.findById(id);
        if (!idProfessor.isPresent()) {
            throw new ProfessorByIdNotExistException("El profesor con id " + id + " no existe");
        }
        var professor = idProfessor.get();
        professorMapper.updateEntityFromRequest(professorRequest, professor);
        var updatedProfessor = professorRepository.save(professor);
        return professorMapper.toResponse(updatedProfessor);
    }

    @Override
    public List<ProfessorResponse> getByNameOrLastName(String text) {
       return professorRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text, text).stream()
                .map(professorMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProfessorResponse> getByEmail(String email) {
       return professorRepository.findByEmailContainingIgnoreCase(email).stream()
                .map(professorMapper::toResponse)
                .toList();
    }

}
