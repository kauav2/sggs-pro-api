package com.mycompany.sggs_pro_api.service;

import com.mycompany.sggs_pro_api.dto.RelatorioGeralDTO;
import com.mycompany.sggs_pro_api.repository.AlimentacaoRepository;
import com.mycompany.sggs_pro_api.repository.SuinoRepository;
import com.mycompany.sggs_pro_api.repository.VacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private final SuinoRepository suinoRepository;
    private final VacinacaoRepository vacinacaoRepository;
    private final AlimentacaoRepository alimentacaoRepository;

    public RelatorioGeralDTO gerarRelatorioGeral() {
        long totalSuinos = suinoRepository.count();
        long totalVacinacoes = vacinacaoRepository.count();
        
        Double totalRacao = alimentacaoRepository.calcularTotalRacaoConsumida();
        // Se o banco estiver vazio, retorna null na soma, então tratamos para zero
        double racaoTratada = (totalRacao != null) ? totalRacao : 0.0;

        // Utilizamos o Builder do Lombok gerado no DTO
        return RelatorioGeralDTO.builder()
                .totalSuinos(totalSuinos)
                .totalVacinacoes(totalVacinacoes)
                .totalRacaoConsumidaKg(racaoTratada)
                .build();
    }
}