package com.mycompany.sggs_pro_api.controller;

import com.mycompany.sggs_pro_api.dto.AlimentacaoRequestDTO;
import com.mycompany.sggs_pro_api.dto.AlimentacaoResponseDTO;
import com.mycompany.sggs_pro_api.service.AlimentacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentacoes")
@RequiredArgsConstructor
@Tag(name = "Alimentação", description = "Controle de consumo de ração e nutrição")
public class AlimentacaoController {

    private final AlimentacaoService service;

    @GetMapping
    @Operation(summary = "Lista histórico de alimentação", description = "Retorna todos os registros de ração fornecida.")
    public ResponseEntity<List<AlimentacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    @Operation(summary = "Registra consumo de ração", description = "Vincula uma quantidade de ração em Kg a um suíno.")
    public ResponseEntity<AlimentacaoResponseDTO> salvar(@Valid @RequestBody AlimentacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }
}