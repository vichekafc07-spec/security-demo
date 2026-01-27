package com.library.spring_security.mapper;

import com.library.spring_security.domain.dto.request.StudentDto;
import com.library.spring_security.domain.dto.response.StudentResponse;
import com.library.spring_security.domain.model.Classroom;
import com.library.spring_security.domain.model.Register;
import com.library.spring_security.domain.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {RegisterMapper.class,ClassroomMapper.class})
public interface StudentMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "register" , target = "register")
    @Mapping(source = "classroom", target = "classroom")
    Student toDto(StudentDto dto, Register register, Classroom classroom);

    @Mapping(source = "id", target = "studentId")
    StudentResponse toResponse(Student student);

}
