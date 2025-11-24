package co.com.andres.campus_universitario.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.andres.campus_universitario.config.exception.StudentsException.StudentsByIdNotExistException;
import co.com.andres.campus_universitario.mapper.StudentsMapper;
import co.com.andres.campus_universitario.model.Dto.StudentsRequest;
import co.com.andres.campus_universitario.model.Dto.StudentsResponse;
import co.com.andres.campus_universitario.repository.StudentsRepository;
import co.com.andres.campus_universitario.service.StudentsService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudensServiceImp implements StudentsService {

    private final StudentsRepository studentsRepository;
    private final StudentsMapper studentsMapper;

    @Override
    public List<StudentsResponse> getAllStudents() {
        return studentsRepository.findAll().stream()
                .map(studentsMapper::toResponse)
                .toList();

    }

    @Override
    public StudentsResponse getById(Long id) {
        return studentsRepository.findById(id)
                .map(studentsMapper::toResponse)
                .orElseThrow(() -> new StudentsByIdNotExistException("El estudiante con id " + id + " no existe"));
    }

    @Override
    public StudentsResponse createStudents(StudentsRequest studentsRequest) {
        var entity = studentsMapper.toEntity(studentsRequest);
       // TODO: encriptar contraseña
        var newStudents = studentsRepository.save(entity);
        return studentsMapper.toResponse(newStudents);
        
    }

    @Override
    public void deleteById(Long id) {
        var idStudents = studentsRepository.findById(id);
        if (!idStudents.isPresent()) {
            throw new StudentsByIdNotExistException("El estudiante con id " + id + " no existe");
        }
        var student = idStudents.get();
        studentsRepository.delete(student);
        
    }

    @Override
    public StudentsResponse updateStudents(Long id, StudentsRequest studentsRequest) {
       
       var idStudents = studentsRepository.findById(id);
        if (!idStudents.isPresent()) {
            throw new StudentsByIdNotExistException("El estudiante con id " + id + " no existe");
        }
         // TODO falta 
        var update= idStudents.get();
        studentsMapper.updateEntityFromRequest(studentsRequest, update);
        var updatedStudents = studentsRepository.save(update);
        return studentsMapper.toResponse(updatedStudents);

    }

    @Override
    public List<StudentsResponse> getByNameOrLastName(String text) {
         return studentsRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text, text).stream()
                .map(studentsMapper::toResponse)
                .toList();
    } 

    @Override
    public List<StudentsResponse> getByEmail(String email) {
          return studentsRepository.findByEmailContainingIgnoreCase(email).stream()
                .map(studentsMapper::toResponse)
                .toList();
    }

}
