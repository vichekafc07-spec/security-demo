package com.library.spring_security.mapper;

import com.library.spring_security.domain.dto.request.ClassroomDto;
import com.library.spring_security.domain.dto.response.ClassroomResponse;
import com.library.spring_security.domain.model.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "classroomName", target = "name")
    Classroom toDto(ClassroomDto dto);
    @Mapping(source = "id", target = "classroomId")
    @Mapping(source = "name", target = "classroomName")
    ClassroomResponse toResponse(Classroom classroom);
}