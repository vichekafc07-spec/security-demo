package com.library.spring_security.domain.repository;

import com.library.spring_security.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
