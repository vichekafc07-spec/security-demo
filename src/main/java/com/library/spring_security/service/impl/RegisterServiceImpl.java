package com.library.spring_security.service.impl;

import com.library.spring_security.domain.dto.request.RegisterDto;
import com.library.spring_security.domain.dto.response.RegisterResponse;
import com.library.spring_security.domain.model.Register;
import com.library.spring_security.domain.repository.RegisterRepository;
import com.library.spring_security.mapper.RegisterMapper;
import com.library.spring_security.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository repository;
    private final RegisterMapper registerMapper;

    @Override
    public RegisterResponse register(RegisterDto dto) {
        Register register = registerMapper.toDto(dto);
        repository.save(register);
        return registerMapper.toResponse(register);
    }

    @Override
    public List<RegisterResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(registerMapper::toResponse)
                .toList();
    }
}
