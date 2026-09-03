package com.mycompany.sggs_pro_api.service;

import com.mycompany.sggs_pro_api.dto.VacinacaoRequestDTO;
import com.mycompany.sggs_pro_api.dto.VacinacaoResponseDTO;
import com.mycompany.sggs_pro_api.entity.Suino;
import com.mycompany.sggs_pro_api.entity.Vacinacao;
import com.mycompany.sggs_pro_api.exception.SuinoNotFoundException;
import com.mycompany.sggs_pro_api.repository.SuinoRepository;
import com.mycompany.sggs_pro_api.repository.VacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacinacaoService {

    private final VacinacaoRepository vacinacaoRepository;
    private final SuinoRepository suinoRepository;

    public List<VacinacaoResponseDTO> listarTodas() {
        return vacinacaoRepository.findAll().stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }
    
    public List<VacinacaoResponseDTO> buscarPorSuino(Long suinoId) {
        return vacinacaoRepository.findBySuinoId(suinoId).stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public VacinacaoResponseDTO salvar(VacinacaoRequestDTO dto) {
        // Verifica se o suíno existe antes de vacinar
        Suino suino = suinoRepository.findById(dto.getSuinoId())
                .orElseThrow(() -> new SuinoNotFoundException("Suíno com ID " + dto.getSuinoId() + " não encontrado."));

        Vacinacao vacina = new Vacinacao();
        vacina.setSuino(suino);
        vacina.setNomeVacina(dto.getNomeVacina());
        vacina.setDataAplicacao(dto.getDataAplicacao());
        vacina.setDose(dto.getDose());

        Vacinacao salva = vacinacaoRepository.save(vacina);
        return converterParaResponseDTO(salva);
    }

    private VacinacaoResponseDTO converterParaResponseDTO(Vacinacao vacinacao) {
        VacinacaoResponseDTO dto = new VacinacaoResponseDTO();
        dto.setId(vacinacao.getId());
        dto.setSuinoId(vacinacao.getSuino().getId());
        dto.setNomeVacina(vacinacao.getNomeVacina());
        dto.setDataAplicacao(vacinacao.getDataAplicacao());
        dto.setDose(vacinacao.getDose());
        return dto;
    }
}