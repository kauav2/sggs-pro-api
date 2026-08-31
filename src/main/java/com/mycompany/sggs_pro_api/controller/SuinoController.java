package com.mycompany.sggs_pro_api.controller;

import jakarta.validation.Valid;

import com.mycompany.sggs_pro_api.dto.SuinoRequestDTO;
import com.mycompany.sggs_pro_api.dto.SuinoResponseDTO;

import com.mycompany.sggs_pro_api.service.SuinoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suinos")
public class SuinoController {

    private final SuinoService service;

    public SuinoController(SuinoService service) {

        this.service = service;

    }

   @GetMapping
    public ResponseEntity<List<SuinoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{numero}")
    public ResponseEntity<SuinoResponseDTO> buscarPorNumero(
            @PathVariable Integer numero) {

        return service.buscarPorNumero(numero)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SuinoResponseDTO> salvar(
            @Valid @RequestBody SuinoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuinoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody SuinoRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();

    }

}