package com.mycompany.sggs_pro_api.repository;

import com.mycompany.sggs_pro_api.entity.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {
    List<Alimentacao> findBySuinoId(Long suinoId);

    // Query customizada para o nosso futuro Relatório (soma a ração consumida)
    @Query("SELECT SUM(a.quantidadeKg) FROM Alimentacao a")
    Double calcularTotalRacaoConsumida();
}