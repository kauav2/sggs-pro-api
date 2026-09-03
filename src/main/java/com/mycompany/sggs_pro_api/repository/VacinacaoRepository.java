package com.mycompany.sggs_pro_api.repository;

import com.mycompany.sggs_pro_api.entity.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
    // Método extra para buscar todas as vacinas de um suíno específico
    List<Vacinacao> findBySuinoId(Long suinoId);
}