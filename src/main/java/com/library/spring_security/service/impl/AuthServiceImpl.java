package com.library.spring_security.service.impl;

import com.library.spring_security.domain.dto.request.SignUpDto;
import com.library.spring_security.domain.model.User;
import com.library.spring_security.domain.repository.UserRepository;
import com.library.spring_security.exceptions.DuplicateResourceException;
import com.library.spring_security.mapper.UserMapper;
import com.library.spring_security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpDto register(SignUpDto request){
        if (userRepository.findByUsername(request.username()).isPresent()){
            throw new DuplicateResourceException("Username already exists");
        }
        User user = userMapper.toDto(request,passwordEncoder);
        user.setRoles("USER");
        User saveUser = userRepository.save(user);
        return userMapper.toEntity(saveUser);
    }
}
