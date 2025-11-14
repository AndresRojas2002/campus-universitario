package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.andres.campus_universitario.model.Dto.ProfessorRequest;
import co.com.andres.campus_universitario.model.Dto.ProfessorResponse;

import co.com.andres.campus_universitario.model.entity.Professors;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(set.of(\"ROLE_PROFESSOR \"))")
    Professors toEntity(ProfessorRequest professorDto);


    ProfessorResponse toResponse(Professors professorsEntity);

}
