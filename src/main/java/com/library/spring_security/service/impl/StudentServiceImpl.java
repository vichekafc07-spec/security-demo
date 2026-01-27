package com.library.spring_security.service.impl;

import com.library.spring_security.domain.dto.request.*;
import com.library.spring_security.domain.dto.response.*;
import com.library.spring_security.domain.model.*;
import com.library.spring_security.domain.repository.ClassroomRepository;
import com.library.spring_security.domain.repository.RegisterRepository;
import com.library.spring_security.domain.repository.StudentRepository;
import com.library.spring_security.exceptions.ResourceNotFoundException;
import com.library.spring_security.mapper.StudentMapper;
import com.library.spring_security.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;
    private final RegisterRepository registerRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse addStudent(StudentDto dto) {
        Classroom classroom = classroomRepository.findById(dto.classroomId())
                .orElseThrow(()-> new ResourceNotFoundException("Classroom not found with " + dto.classroomId()));
        Register register = registerRepository.findById(dto.registerId())
                .orElseThrow(()-> new ResourceNotFoundException("Register not found with " + dto.registerId()));
        Student student = studentMapper.toDto(dto,register,classroom);
        Student saveStudent = studentRepository.save(student);
        return studentMapper.toResponse(saveStudent);
    }
}
