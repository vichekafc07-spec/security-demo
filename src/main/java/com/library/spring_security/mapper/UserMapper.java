package com.library.spring_security.mapper;

import com.library.spring_security.domain.dto.request.SignUpDto;
import com.library.spring_security.domain.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "roles" , ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(dto.password()))")
    User toDto(SignUpDto dto, @Context PasswordEncoder passwordEncoder);

    SignUpDto toEntity(User user);

}
