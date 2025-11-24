package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.campus_universitario.model.Dto.ProfessorRequest;
import co.com.andres.campus_universitario.model.Dto.ProfessorResponse;

import co.com.andres.campus_universitario.model.entity.Professors;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(Role.PROFESSOR)")
    Professors toEntity(ProfessorRequest professorDto);


    ProfessorResponse toResponse(Professors professorsEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", ignore = true)  // no se actualiza
    @Mapping(target = "password", ignore = true)  // no se actualiza
    @Mapping(target = "role", ignore = true)  // no se actualiza
    void updateEntityFromRequest(ProfessorRequest request, @MappingTarget Professors professor);
    


}
