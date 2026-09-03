package com.mycompany.sggs_pro_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "alimentacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "suino_id", nullable = false)
    private Suino suino;

    @NotBlank(message = "O tipo de ração é obrigatório.")
    private String tipoRacao;

    @NotNull(message = "A quantidade em Kg é obrigatória.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    private Double quantidadeKg;

    @NotNull(message = "A data da alimentação é obrigatória.")
    private LocalDate dataAlimentacao;
}