package com.library.spring_security.service.impl;

import com.library.spring_security.domain.dto.request.SignUpDto;
import com.library.spring_security.domain.model.User;
import com.library.spring_security.domain.repository.UserRepository;
import com.library.spring_security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(SignUpDto request){
        if (userRepository.findByUsername(request.username()).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles("USER");
        userRepository.save(user);
    }
}
