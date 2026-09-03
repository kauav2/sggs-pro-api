package com.mycompany.sggs_pro_api.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VacinacaoResponseDTO {
    private Long id;
    private Long suinoId;
    private String nomeVacina;
    private LocalDate dataAplicacao;
    private String dose;
}