package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.andres.campus_universitario.model.Dto.StudentsRequest;
import co.com.andres.campus_universitario.model.Dto.StudentsResponse;
import co.com.andres.campus_universitario.model.entity.Students;

@Mapper(componentModel = "spring")
public interface StudentsMapper {

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "role", expression = "java(set.of(\"ROLE_STUDENT\"))")
    Students toEntity(StudentsRequest studentsDto);

    StudentsResponse toResponse (Students studentsEntity);


}
