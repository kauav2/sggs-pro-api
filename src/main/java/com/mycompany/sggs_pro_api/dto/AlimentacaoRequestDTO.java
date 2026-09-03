package com.mycompany.sggs_pro_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlimentacaoRequestDTO {

    @NotNull(message = "O ID do suíno é obrigatório.")
    private Long suinoId;

    @NotBlank(message = "O tipo de ração é obrigatório.")
    private String tipoRacao;

    @NotNull(message = "A quantidade em Kg é obrigatória.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    private Double quantidadeKg;

    @NotNull(message = "A data é obrigatória.")
    private LocalDate dataAlimentacao;
}