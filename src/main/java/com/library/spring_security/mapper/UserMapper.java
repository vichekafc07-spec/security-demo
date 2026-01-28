package com.library.spring_security.mapper;

import com.library.spring_security.domain.dto.request.SignUpDto;
import com.library.spring_security.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "roles" , ignore = true)
    User toDto(SignUpDto dto);

    SignUpDto toEntity(User user);

}
