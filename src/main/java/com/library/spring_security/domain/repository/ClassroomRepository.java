package com.library.spring_security.domain.repository;

import com.library.spring_security.domain.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
