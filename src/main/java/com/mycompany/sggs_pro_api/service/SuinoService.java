package com.mycompany.sggs_pro_api.service;

import com.mycompany.sggs_pro_api.exception.SuinoNotFoundException;

import com.mycompany.sggs_pro_api.dto.SuinoRequestDTO;
import com.mycompany.sggs_pro_api.dto.SuinoResponseDTO;

import com.mycompany.sggs_pro_api.entity.Suino;
import com.mycompany.sggs_pro_api.repository.SuinoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuinoService {

    private final SuinoRepository repository;

    public SuinoService(SuinoRepository repository) {

        this.repository = repository;

    }

    public List<SuinoResponseDTO> listarTodos() {

        List<Suino> suinos = repository.findAll();

        return suinos.stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public Optional<SuinoResponseDTO> buscarPorNumero(Integer numero) {

        return repository.findByNumero(numero)
                .map(this::converterParaResponseDTO);
    }

    public SuinoResponseDTO salvar(SuinoRequestDTO dto) {

        Suino suino = converterParaEntidade(dto);

        Suino salvo = repository.save(suino);

        return converterParaResponseDTO(salvo);
    }

     private Suino converterParaEntidade(SuinoRequestDTO dto) {

        Suino suino = new Suino();

        suino.setNumero(dto.getNumero());
        suino.setPeso(dto.getPeso());
        suino.setIdade(dto.getIdade());
        suino.setRaca(dto.getRaca());
        suino.setFinalidade(dto.getFinalidade());

        return suino;
    }

    private SuinoResponseDTO converterParaResponseDTO(Suino suino) {

        SuinoResponseDTO dto = new SuinoResponseDTO();

        dto.setId(suino.getId());
        dto.setNumero(suino.getNumero());
        dto.setPeso(suino.getPeso());
        dto.setIdade(suino.getIdade());
        dto.setRaca(suino.getRaca());
        dto.setFinalidade(suino.getFinalidade());

        return dto;
    }

    public SuinoResponseDTO atualizar(Long id, SuinoRequestDTO dto) {

        Suino suino = repository.findById(id)
                .orElseThrow(() ->
            new SuinoNotFoundException(
                    "Não foi encontrado um suíno com o ID " + id
            )
    );

        suino.setNumero(dto.getNumero());
        suino.setPeso(dto.getPeso());
        suino.setIdade(dto.getIdade());
        suino.setRaca(dto.getRaca());
        suino.setFinalidade(dto.getFinalidade());

        Suino atualizado = repository.save(suino);

        return converterParaResponseDTO(atualizado);
    }

    public void excluir(Long id) {

        Suino suino = repository.findById(id)
                .orElseThrow(() ->
            new SuinoNotFoundException(
                    "Não foi encontrado um suíno com o ID " + id
            )
    );

        repository.delete(suino);
    }

   

}