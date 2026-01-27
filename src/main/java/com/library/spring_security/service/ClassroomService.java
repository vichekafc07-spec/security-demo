package com.library.spring_security.service;

import com.library.spring_security.domain.dto.request.ClassroomDto;
import com.library.spring_security.domain.dto.response.ClassroomResponse;

import java.util.List;

public interface ClassroomService {
    ClassroomResponse addClassroom(ClassroomDto dto);

    List<ClassroomResponse> getAllClassroom();
}
