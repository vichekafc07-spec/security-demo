package com.library.spring_security.domain.repository;

import com.library.spring_security.domain.model.Role;
import com.library.spring_security.domain.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
