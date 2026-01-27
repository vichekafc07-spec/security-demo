package com.library.spring_security.controller;

import com.library.spring_security.domain.dto.request.StudentDto;
import com.library.spring_security.domain.dto.response.StudentResponse;
import com.library.spring_security.exceptions.APIResponse;
import com.library.spring_security.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<APIResponse<StudentResponse>> addStudent(@RequestBody StudentDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponse.create(studentService.addStudent(dto)));
    }
}