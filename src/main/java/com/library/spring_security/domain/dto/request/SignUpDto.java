package com.library.spring_security.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record SignUpDto(
        @NotEmpty(message = "Username must not empty") String username ,
        @NotEmpty(message = "Password must not empty") String password) {
}
