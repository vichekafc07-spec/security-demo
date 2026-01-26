package com.library.spring_security.domain.repository;

import com.library.spring_security.domain.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Long> {
}
