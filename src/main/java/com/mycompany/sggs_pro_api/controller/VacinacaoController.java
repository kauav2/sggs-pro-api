package com.mycompany.sggs_pro_api.controller;

import com.mycompany.sggs_pro_api.dto.VacinacaoRequestDTO;
import com.mycompany.sggs_pro_api.dto.VacinacaoResponseDTO;
import com.mycompany.sggs_pro_api.service.VacinacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinacoes")
@RequiredArgsConstructor
@Tag(name = "Vacinações", description = "Gerenciamento do controle sanitário e vacinas dos suínos")
public class VacinacaoController {

    private final VacinacaoService service;

    @GetMapping
    @Operation(summary = "Lista todas as vacinações", description = "Retorna o histórico completo de vacinas aplicadas na granja.")
    public ResponseEntity<List<VacinacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/suino/{suinoId}")
    @Operation(summary = "Busca vacinas por suíno", description = "Lista todas as vacinações vinculadas a um ID de suíno específico.")
    public ResponseEntity<List<VacinacaoResponseDTO>> buscarPorSuino(@PathVariable Long suinoId) {
        return ResponseEntity.ok(service.buscarPorSuino(suinoId));
    }

    @PostMapping
    @Operation(summary = "Registra vacinação", description = "Salva uma nova aplicação de vacina para um suíno existente.")
    public ResponseEntity<VacinacaoResponseDTO> salvar(@Valid @RequestBody VacinacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }
}