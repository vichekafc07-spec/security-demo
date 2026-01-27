package com.library.spring_security.controller;

import com.library.spring_security.domain.dto.request.ClassroomDto;
import com.library.spring_security.domain.dto.response.ClassroomResponse;
import com.library.spring_security.exceptions.APIResponse;
import com.library.spring_security.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<APIResponse<ClassroomResponse>> addClassroom(@RequestBody ClassroomDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponse.create(classroomService.addClassroom(dto),"Classroom create successfully"));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ClassroomResponse>>> getAllClassroom(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(APIResponse.ok(classroomService.getAllClassroom(),"Classroom Fetching"));
    }

}