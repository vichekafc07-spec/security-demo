package com.library.spring_security.service;

import com.library.spring_security.domain.dto.request.StudentDto;
import com.library.spring_security.domain.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse addStudent(StudentDto dto);
}
