package com.library.spring_security.mapper;

import com.library.spring_security.domain.dto.request.RegisterDto;
import com.library.spring_security.domain.dto.response.RegisterResponse;
import com.library.spring_security.domain.model.Register;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "studentName" , target = "name")
    Register toDto(RegisterDto dto);

    @Mapping(source = "id" , target = "studentId")
    @Mapping(source = "name" , target = "studentName")
    RegisterResponse toResponse(Register register);
}