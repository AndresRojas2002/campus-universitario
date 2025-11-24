package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import co.com.andres.campus_universitario.model.Dto.StudentsRequest;
import co.com.andres.campus_universitario.model.Dto.StudentsResponse;
import co.com.andres.campus_universitario.model.entity.Students;

@Mapper(componentModel = "spring")
public interface StudentsMapper {

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "role", expression = "java(Role.STUDENT)")
    Students toEntity(StudentsRequest studentsDto);


    StudentsResponse toResponse (Students students);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", ignore = true)  // no se actualiza
    @Mapping(target = "password", ignore = true)  // no se actualiza
    @Mapping(target = "role", ignore = true)  // no se actualiza

    // @MappingTarget  le dice a MapStruct que no cree una entidad nueva, sino que actualice el objeto que se recibe
    //este metodo convierte un StudentsRequest en una entidad Students existente
    void updateEntityFromRequest(StudentsRequest request, @MappingTarget Students student);
    



}
