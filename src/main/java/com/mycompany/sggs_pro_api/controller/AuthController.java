package com.mycompany.sggs_pro_api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.mycompany.sggs_pro_api.dto.LoginRequestDTO;
import com.mycompany.sggs_pro_api.dto.LoginResponseDTO;
import com.mycompany.sggs_pro_api.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }
}