package com.library.spring_security.service;

import com.library.spring_security.domain.dto.request.RegisterDto;
import com.library.spring_security.domain.dto.response.RegisterResponse;

import java.util.List;

public interface RegisterService {
    RegisterResponse register(RegisterDto dto);
    List<RegisterResponse> getAll();
}
