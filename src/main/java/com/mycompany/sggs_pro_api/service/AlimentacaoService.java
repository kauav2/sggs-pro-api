package com.mycompany.sggs_pro_api.service;

import com.mycompany.sggs_pro_api.dto.AlimentacaoRequestDTO;
import com.mycompany.sggs_pro_api.dto.AlimentacaoResponseDTO;
import com.mycompany.sggs_pro_api.entity.Alimentacao;
import com.mycompany.sggs_pro_api.entity.Suino;
import com.mycompany.sggs_pro_api.exception.SuinoNotFoundException;
import com.mycompany.sggs_pro_api.repository.AlimentacaoRepository;
import com.mycompany.sggs_pro_api.repository.SuinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;
    private final SuinoRepository suinoRepository;

    public List<AlimentacaoResponseDTO> listarTodas() {
        return alimentacaoRepository.findAll().stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public AlimentacaoResponseDTO salvar(AlimentacaoRequestDTO dto) {
        Suino suino = suinoRepository.findById(dto.getSuinoId())
                .orElseThrow(() -> new SuinoNotFoundException("Suíno com ID " + dto.getSuinoId() + " não encontrado."));

        Alimentacao alimentacao = new Alimentacao();
        alimentacao.setSuino(suino);
        alimentacao.setTipoRacao(dto.getTipoRacao());
        alimentacao.setQuantidadeKg(dto.getQuantidadeKg());
        alimentacao.setDataAlimentacao(dto.getDataAlimentacao());

        Alimentacao salva = alimentacaoRepository.save(alimentacao);
        return converterParaResponseDTO(salva);
    }

    private AlimentacaoResponseDTO converterParaResponseDTO(Alimentacao alimentacao) {
        AlimentacaoResponseDTO dto = new AlimentacaoResponseDTO();
        dto.setId(alimentacao.getId());
        dto.setSuinoId(alimentacao.getSuino().getId());
        dto.setTipoRacao(alimentacao.getTipoRacao());
        dto.setQuantidadeKg(alimentacao.getQuantidadeKg());
        dto.setDataAlimentacao(alimentacao.getDataAlimentacao());
        return dto;
    }
}