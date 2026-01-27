package com.library.spring_security.service.impl;

import com.library.spring_security.domain.dto.request.ClassroomDto;
import com.library.spring_security.domain.dto.response.ClassroomResponse;
import com.library.spring_security.domain.model.Classroom;
import com.library.spring_security.domain.repository.ClassroomRepository;
import com.library.spring_security.mapper.ClassroomMapper;
import com.library.spring_security.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    @Override
    public ClassroomResponse addClassroom(ClassroomDto dto) {
        Classroom classroom = classroomMapper.toDto(dto);
        return classroomMapper.toResponse(classroomRepository.save(classroom));
    }

    @Override
    public List<ClassroomResponse> getAllClassroom() {
        return classroomRepository.findAll()
                .stream()
                .map(classroomMapper::toResponse)
                .toList();
    }
}