package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.andres.campus_universitario.model.Dto.EnrollmentsRequest;
import co.com.andres.campus_universitario.model.Dto.EnrollmentsResponse;

import co.com.andres.campus_universitario.model.entity.Enrollments;


@Mapper(componentModel = "spring")
public interface EnrollmentsMapper {
     @Mapping(target = "id", ignore = true)
      @Mapping(target = "enrollmentsState", expression = "java(EnrollmentsState.ACTIVE)")
    
    Enrollments toEntity(EnrollmentsRequest studentsDto);

    EnrollmentsResponse toResponse (Enrollments enrollmentsEntity);

}
