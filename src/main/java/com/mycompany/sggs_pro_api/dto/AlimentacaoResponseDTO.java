package com.mycompany.sggs_pro_api.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AlimentacaoResponseDTO {
    private Long id;
    private Long suinoId;
    private String tipoRacao;
    private Double quantidadeKg;
    private LocalDate dataAlimentacao;
}