package com.library.spring_security.domain.dto.request;

public record StudentDto(String skill,
                         Long registerId,
                         Long classroomId) {
}