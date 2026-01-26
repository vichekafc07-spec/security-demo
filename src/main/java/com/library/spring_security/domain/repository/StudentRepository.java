package com.library.spring_security.domain.repository;

import com.library.spring_security.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
