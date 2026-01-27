package com.library.spring_security.controller;

import com.library.spring_security.domain.dto.request.RegisterDto;
import com.library.spring_security.domain.dto.response.RegisterResponse;
import com.library.spring_security.exceptions.APIResponse;
import com.library.spring_security.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<APIResponse<RegisterResponse>> register(@RequestBody RegisterDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponse.create(registerService.register(dto),"Student Register"));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<RegisterResponse>>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(APIResponse.ok(registerService.getAll(),"Fetching data "));
    }

}
