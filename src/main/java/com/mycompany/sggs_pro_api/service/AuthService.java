package com.mycompany.sggs_pro_api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mycompany.sggs_pro_api.exception.InvalidCredentialsException;

import com.mycompany.sggs_pro_api.dto.LoginRequestDTO;
import com.mycompany.sggs_pro_api.dto.LoginResponseDTO;
import com.mycompany.sggs_pro_api.entity.Usuario;
import com.mycompany.sggs_pro_api.repository.UsuarioRepository;
import com.mycompany.sggs_pro_api.security.JwtService;

@Service
public class AuthService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = repository.findByLogin(dto.getLogin())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Login ou senha inválidos"));

        if (!passwordEncoder.matches(
                dto.getSenha(),
                usuario.getSenha())) {

            throw new InvalidCredentialsException("Login ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuario.getLogin());

        return new LoginResponseDTO(token);
    }
}