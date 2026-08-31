package com.mycompany.sggs_pro_api.controller;

import org.springframework.web.bind.annotation.*;

import com.mycompany.sggs_pro_api.dto.LoginRequestDTO;
import com.mycompany.sggs_pro_api.dto.LoginResponseDTO;
import com.mycompany.sggs_pro_api.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginRequestDTO dto) {

        return service.login(dto);
    }
}