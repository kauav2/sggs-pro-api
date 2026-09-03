package com.mycompany.sggs_pro_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // Padrão de projeto Builder do Lombok para facilitar a criação do objeto
public class RelatorioGeralDTO {
    private long totalSuinos;
    private long totalVacinacoes;
    private double totalRacaoConsumidaKg;
}