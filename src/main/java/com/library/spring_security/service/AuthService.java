package com.library.spring_security.service;

import com.library.spring_security.domain.dto.RegisterRequest;
import com.library.spring_security.domain.model.Role;
import com.library.spring_security.domain.model.RoleName;
import com.library.spring_security.domain.model.User;
import com.library.spring_security.domain.repository.RoleRepository;
import com.library.spring_security.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request){
        if (userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email is already taken");
        }
        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(()-> new RuntimeException("Default role not found"));
       User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(Set.of(role))
                .enabled(true)
                .build();
       return userRepository.save(user);
    }
}
