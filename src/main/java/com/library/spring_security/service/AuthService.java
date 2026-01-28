package com.library.spring_security.service;

import com.library.spring_security.domain.dto.request.SignUpDto;
import jakarta.validation.Valid;

public interface AuthService {
    SignUpDto register(@Valid SignUpDto dto);
}
