package com.mycompany.sggs_pro_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacinacaoRequestDTO {

    @NotNull(message = "O ID do suíno é obrigatório.")
    private Long suinoId;

    @NotBlank(message = "O nome da vacina é obrigatório.")
    private String nomeVacina;

    @NotNull(message = "A data da aplicação é obrigatória.")
    private LocalDate dataAplicacao;

    @NotBlank(message = "A dose é obrigatória.")
    private String dose;
}