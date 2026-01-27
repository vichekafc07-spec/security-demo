package com.library.spring_security.domain.dto.response;

public record StudentResponse(Long studentId,
                              String skill,
                              RegisterResponse register,
                              ClassroomResponse classroom) {
}