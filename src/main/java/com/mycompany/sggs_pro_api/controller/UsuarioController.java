package com.mycompany.sggs_pro_api.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.mycompany.sggs_pro_api.dto.UsuarioRequestDTO;
import com.mycompany.sggs_pro_api.dto.UsuarioResponseDTO;
import com.mycompany.sggs_pro_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public UsuarioResponseDTO salvar(
            @Valid @RequestBody UsuarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}