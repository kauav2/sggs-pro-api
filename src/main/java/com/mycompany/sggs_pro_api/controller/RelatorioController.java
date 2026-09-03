package com.mycompany.sggs_pro_api.controller;

import com.mycompany.sggs_pro_api.dto.RelatorioGeralDTO;
import com.mycompany.sggs_pro_api.service.RelatorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
@Tag(name = "Relatórios Gerenciais", description = "Métricas e painéis de desempenho da granja")
public class RelatorioController {

    private final RelatorioService service;

    @GetMapping("/geral")
    @Operation(summary = "Gera relatório consolidado", description = "Calcula o total de animais, vacinas aplicadas e volume total de ração consumida.")
    public ResponseEntity<RelatorioGeralDTO> obterRelatorioGeral() {
        return ResponseEntity.ok(service.gerarRelatorioGeral());
    }
}