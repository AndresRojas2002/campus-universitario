package co.com.andres.campus_universitario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import co.com.andres.campus_universitario.model.Dto.CourseRequest;
import co.com.andres.campus_universitario.model.Dto.CourseResponse;

import co.com.andres.campus_universitario.model.entity.Courses;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    Courses toEntity(CourseRequest courseDto);

    CourseResponse toResponse(Courses coursesEntity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(CourseRequest request, @MappingTarget Courses course);



}
